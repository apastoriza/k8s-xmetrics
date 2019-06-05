package com.k8s.xmetrics.scheduler;

import com.k8s.xmetrics.model.hardware.CPUInfo;
import com.k8s.xmetrics.model.hardware.ComputerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.util.Arrays;

/**
 * @author apastoriza
 */
public class HardwareMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(HardwareMonitorTask.class);

	@Override
	public void run() {
		final SystemInfo systemInfo = new SystemInfo();
		final HardwareAbstractionLayer hal = systemInfo.getHardware();
		final OperatingSystem os = systemInfo.getOperatingSystem();
		this.monitorComputer(hal);
		this.monitorCPU(hal);
	}

	private void monitorComputer(final HardwareAbstractionLayer hal) {
		final ComputerInfo computerInfo = this.readComputerInfo(hal.getComputerSystem());
	}

	private void monitorCPU(final HardwareAbstractionLayer hal) {
		final CPUInfo cpuInfo = this.readCPUInfo(hal.getProcessor());
	}

	private ComputerInfo readComputerInfo(final ComputerSystem computerSystem) {
		final ComputerInfo computerInfo = new ComputerInfo();
		computerInfo.setManufacturer(computerSystem.getManufacturer());
		computerInfo.setModel(computerSystem.getModel());
		computerInfo.setSerialNumber(computerSystem.getSerialNumber());
		LOGGER.warn("Computer Info: {}", computerInfo);
		return computerInfo;
	}

	private CPUInfo readCPUInfo(final CentralProcessor processor) {
		final CPUInfo cpuInfo = new CPUInfo();
		cpuInfo.setPhysicalPackageCount(processor.getPhysicalPackageCount());
		cpuInfo.setPhysicalProcessorCount(processor.getPhysicalProcessorCount());
		cpuInfo.setLogicalProcessorCount(processor.getLogicalProcessorCount());

		cpuInfo.setIdentifier(processor.getIdentifier());
		cpuInfo.setProcessorID(processor.getProcessorID());

		cpuInfo.setSystemUptimeInMillis(processor.getSystemUptime() * 1000L);



		

		LOGGER.warn("CPU Info: {}", cpuInfo);
		return cpuInfo;
	}
}
