package com.k8s.xmetrics.scheduler;

import com.k8s.xmetrics.model.hardware.CPUInfo;
import com.k8s.xmetrics.model.hardware.ComputerInfo;
import com.k8s.xmetrics.model.hardware.MemoryInfo;
import com.k8s.xmetrics.model.hardware.NetworkInfo;
import com.k8s.xmetrics.service.hardware.CPUInfoService;
import com.k8s.xmetrics.service.hardware.ComputerInfoService;
import com.k8s.xmetrics.service.hardware.MemoryInfoService;
import com.k8s.xmetrics.service.hardware.NetworkInfoService;
import com.k8s.xmetrics.service.kafka.ProducerService;
import com.k8s.xmetrics.vo.hardware.CPUInfoFactory;
import com.k8s.xmetrics.vo.hardware.CPUInfoVO;
import com.k8s.xmetrics.vo.hardware.ComputerInfoFactory;
import com.k8s.xmetrics.vo.hardware.ComputerInfoVO;
import com.k8s.xmetrics.vo.hardware.MemoryInfoFactory;
import com.k8s.xmetrics.vo.hardware.MemoryInfoVO;
import com.k8s.xmetrics.vo.hardware.NetworkInfoFactory;
import com.k8s.xmetrics.vo.hardware.NetworkInfoVO;
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
	private ProducerService producerService;

	private ComputerInfoFactory computerInfoFactory;
	private CPUInfoFactory cpuInfoFactory;
	private MemoryInfoFactory memoryInfoFactory;
	private NetworkInfoFactory networkInfoFactory;

	@Override
	public void run() {
		LOGGER.debug("Running HW monitoring...");
		this.monitorComputer();
		this.monitorCPU();
		this.monitorMemory();
		this.monitorNetwork();
	}

	private void monitorNetwork() {
		final NetworkInfo networkInfo = this.networkInfoService.readInfo();
		final NetworkInfoVO networkInfoVO = this.networkInfoFactory.toVO(networkInfo);
		this.producerService.send("NetworkInfo", networkInfoVO);
	}

	private void monitorMemory() {
		final MemoryInfo memoryInfo = this.memoryInfoService.readInfo();
		final MemoryInfoVO memoryInfoVO = this.memoryInfoFactory.toVO(memoryInfo);
		this.producerService.send("MemoryInfo", memoryInfoVO);
	}

	private void monitorComputer() {
		final ComputerInfo computerInfo = this.computerInfoService.readInfo();
		final ComputerInfoVO computerInfoVO = this.computerInfoFactory.toVO(computerInfo);
		this.producerService.send("ComputerInfo", computerInfoVO);
	}

	private void monitorCPU() {
		final CPUInfo cpuInfo = this.cpuInfoService.readInfo();
		final CPUInfoVO cpuInfoVO = this.cpuInfoFactory.toVO(cpuInfo);
		this.producerService.send("CPUInfo", cpuInfoVO);
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

	public void setProducerService(final ProducerService producerService) {
		this.producerService = producerService;
	}

	public void setComputerInfoFactory(final ComputerInfoFactory computerInfoFactory) {
		this.computerInfoFactory = computerInfoFactory;
	}

	public void setCpuInfoFactory(final CPUInfoFactory cpuInfoFactory) {
		this.cpuInfoFactory = cpuInfoFactory;
	}

	public void setMemoryInfoFactory(final MemoryInfoFactory memoryInfoFactory) {
		this.memoryInfoFactory = memoryInfoFactory;
	}

	public void setNetworkInfoFactory(final NetworkInfoFactory networkInfoFactory) {
		this.networkInfoFactory = networkInfoFactory;
	}
}
