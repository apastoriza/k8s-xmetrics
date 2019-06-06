package com.k8s.xmetrics.scheduler;

import com.k8s.xmetrics.model.hardware.CPUInfo;
import com.k8s.xmetrics.model.hardware.ComputerInfo;
import com.k8s.xmetrics.model.hardware.MemoryInfo;
import com.k8s.xmetrics.model.hardware.NetworkInfo;
import com.k8s.xmetrics.service.hardware.CPUInfoService;
import com.k8s.xmetrics.service.hardware.ComputerInfoService;
import com.k8s.xmetrics.service.hardware.MemoryInfoService;
import com.k8s.xmetrics.service.hardware.NetworkInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author apastoriza
 */
public class HardwareMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(HardwareMonitorTask.class);
	private CPUInfoService cpuInfoService;
	private ComputerInfoService computerInfoService;
	private MemoryInfoService memoryInfoService;
	private NetworkInfoService networkInfoService;

	@Override
	public void run() {
		LOGGER.warn("Running HW monitoring....");
		final ComputerInfo computerInfo = this.computerInfoService.readInfo();
		final CPUInfo cpuInfo = this.cpuInfoService.readInfo();
		final MemoryInfo memoryInfo = this.memoryInfoService.readInfo();
		final NetworkInfo networkInfo = this.networkInfoService.readInfo();
	}

	public void setCpuInfoService(final CPUInfoService cpuInfoService) {
		this.cpuInfoService = cpuInfoService;
	}

	public void setComputerInfoService(final ComputerInfoService computerInfoService) {
		this.computerInfoService = computerInfoService;
	}

	public void setMemoryInfoService(final MemoryInfoService memoryInfoService) {
		this.memoryInfoService = memoryInfoService;
	}

	public void setNetworkInfoService(final NetworkInfoService networkInfoService) {
		this.networkInfoService = networkInfoService;
	}
}
