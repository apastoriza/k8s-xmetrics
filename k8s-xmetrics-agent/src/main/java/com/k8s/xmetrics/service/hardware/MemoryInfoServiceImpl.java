package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.MemoryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * @author apastoriza
 */
public class MemoryInfoServiceImpl implements MemoryInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemoryInfoServiceImpl.class);

	@Override
	public MemoryInfo readInfo() {
		final MemoryInfo memoryInfo = new MemoryInfo();
		final SystemInfo systemInfo = new SystemInfo();
		final HardwareAbstractionLayer hal = systemInfo.getHardware();
		final GlobalMemory memory = hal.getMemory();
		memoryInfo.setAvailableBytes(memory.getAvailable());
		memoryInfo.setTotalBytes(memory.getTotal());
		memoryInfo.setSwapUsedBytes(memory.getSwapUsed());
		memoryInfo.setSwapTotalBytes(memory.getSwapTotal());
		LOGGER.debug("Memory Info: {}", memoryInfo);
		return memoryInfo;
	}
}
