package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.ComputerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * @author apastoriza
 */
public class ComputerInfoServiceImpl implements ComputerInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ComputerInfoServiceImpl.class);

	@Override
	public ComputerInfo readInfo() {
		final SystemInfo systemInfo = new SystemInfo();
		final HardwareAbstractionLayer hal = systemInfo.getHardware();
		final ComputerSystem computerSystem = hal.getComputerSystem();

		final ComputerInfo computerInfo = new ComputerInfo();
		computerInfo.setManufacturer(computerSystem.getManufacturer());
		computerInfo.setModel(computerSystem.getModel());
		computerInfo.setSerialNumber(computerSystem.getSerialNumber());
		LOGGER.warn("Computer Info: {}", computerInfo);
		return computerInfo;
	}
}
