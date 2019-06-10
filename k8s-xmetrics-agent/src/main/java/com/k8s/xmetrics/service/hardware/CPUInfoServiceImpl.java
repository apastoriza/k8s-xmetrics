package com.k8s.xmetrics.service.hardware;

import com.google.common.collect.Lists;
import com.k8s.xmetrics.model.hardware.CPUInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;

import java.util.List;

/**
 * @author apastoriza
 */
public class CPUInfoServiceImpl implements CPUInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CPUInfoServiceImpl.class);
	private static final double PERCENT = 100.0;
	private static final long ONE_SEC_IN_MILLIS = 1000L;

	@Override
	public CPUInfo readInfo() {

		final SystemInfo systemInfo = new SystemInfo();
		final HardwareAbstractionLayer hal = systemInfo.getHardware();
		final CentralProcessor processor = hal.getProcessor();

		final CPUInfo cpuInfo = new CPUInfo();
		cpuInfo.setPhysicalPackageCount(processor.getPhysicalPackageCount());
		cpuInfo.setPhysicalProcessorCount(processor.getPhysicalProcessorCount());
		cpuInfo.setLogicalProcessorCount(processor.getLogicalProcessorCount());

		cpuInfo.setIdentifier(processor.getIdentifier());
		cpuInfo.setProcessorID(processor.getProcessorID());

		cpuInfo.setSystemUptimeInMillis(processor.getSystemUptime() * ONE_SEC_IN_MILLIS);


		this.populateTicks(processor, cpuInfo);
		this.populateLoads(processor, cpuInfo);

		LOGGER.debug("CPU Info: {}", cpuInfo);
		return cpuInfo;
	}

	private void populateLoads(final CentralProcessor processor, final CPUInfo cpuInfo) {
		cpuInfo.setCpuLoadPercentCountingTicks(processor.getSystemCpuLoadBetweenTicks() * PERCENT);
		cpuInfo.setCpuLoadPercentOSMXBean(processor.getSystemCpuLoad() * PERCENT);

		final double[] loadAverage = processor.getSystemLoadAverage(3);

		final List<Double> cpuLoadAverages = Lists.newArrayList();
		if (loadAverage[0] >= 0.0) {
			cpuLoadAverages.add(loadAverage[0]);
		}

		if (loadAverage[1] >= 0.0) {
			cpuLoadAverages.add(loadAverage[1]);
		}

		if (loadAverage[2] >= 0.0) {
			cpuLoadAverages.add(loadAverage[2]);
		}
		cpuInfo.setCpuLoadAverages(cpuLoadAverages);


		// per core CPU

		final List<Double> cpuLoadPercentProcessors = Lists.newArrayList();
		final double[] load = processor.getProcessorCpuLoadBetweenTicks();
		for (final double avg : load) {
			cpuLoadPercentProcessors.add(avg * PERCENT);
		}
		cpuInfo.setCpuLoadPercentProcessors(cpuLoadPercentProcessors);
	}

	private void populateTicks(final CentralProcessor processor, final CPUInfo cpuInfo) {
		final long[] prevTicks = processor.getSystemCpuLoadTicks();
		processor.getProcessorCpuLoadTicks();
		// Wait a second...
		Util.sleep(ONE_SEC_IN_MILLIS);
		final long[] ticks = processor.getSystemCpuLoadTicks();

		final long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
		final long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
		final long sys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
		final long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
		final long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
		final long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
		final long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
		final long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
		final long totalCpu = user + nice + sys + idle + iowait + irq + softirq + steal;


		cpuInfo.setCpuUser(ticks[CentralProcessor.TickType.USER.getIndex()]);
		cpuInfo.setCpuNice(ticks[CentralProcessor.TickType.NICE.getIndex()]);
		cpuInfo.setCpuSys(ticks[CentralProcessor.TickType.SYSTEM.getIndex()]);
		cpuInfo.setCpuIdle(ticks[CentralProcessor.TickType.IDLE.getIndex()]);
		cpuInfo.setCpuIOWait(ticks[CentralProcessor.TickType.IOWAIT.getIndex()]);
		cpuInfo.setCpuIRQ(ticks[CentralProcessor.TickType.IRQ.getIndex()]);
		cpuInfo.setCpuSoftIRQ(ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]);
		cpuInfo.setCpuSteal(ticks[CentralProcessor.TickType.STEAL.getIndex()]);
		cpuInfo.setTotalCPU(totalCpu);


		cpuInfo.setCpuUserPercent(PERCENT * user / totalCpu);
		cpuInfo.setCpuNicePercent(PERCENT * nice / totalCpu);
		cpuInfo.setCpuSysPercent(PERCENT * sys / totalCpu);
		cpuInfo.setCpuIdlePercent(PERCENT * idle / totalCpu);
		cpuInfo.setCpuIOWaitPercent(PERCENT * iowait / totalCpu);
		cpuInfo.setCpuIRQPercent(PERCENT * irq / totalCpu);
		cpuInfo.setCpuSoftIRQPercent(PERCENT * softirq / totalCpu);
		cpuInfo.setCpuStealPercent(PERCENT * steal / totalCpu);
	}
}
