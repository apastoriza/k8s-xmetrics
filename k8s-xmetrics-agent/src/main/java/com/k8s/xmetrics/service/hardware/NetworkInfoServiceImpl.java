package com.k8s.xmetrics.service.hardware;

import com.google.common.collect.Lists;
import com.k8s.xmetrics.model.hardware.NetworkInfo;
import com.k8s.xmetrics.model.hardware.NetworkInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.util.FormatUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author apastoriza
 */
public class NetworkInfoServiceImpl implements NetworkInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NetworkInfoServiceImpl.class);

	@Override
	public NetworkInfo readInfo() {
		final NetworkInfo networkInfo = new NetworkInfo();
		final SystemInfo systemInfo = new SystemInfo();
		final HardwareAbstractionLayer hal = systemInfo.getHardware();
		this.populateNetworkInterfaces(hal.getNetworkIFs(), networkInfo);
		LOGGER.warn("Network Info: {}", networkInfo);
		return networkInfo;
	}

	private void populateNetworkInterfaces(final NetworkIF[] networkIFs, final NetworkInfo networkInfo){

		final List<NetworkInterface> networkInterfaces = Lists.newArrayList();

		for (final NetworkIF net : networkIFs) {
			final NetworkInterface networkInterface = new NetworkInterface();
			networkInterface.setName(net.getName());
			networkInterface.setDisplayName(net.getDisplayName());
			networkInterface.setMacAddress(net.getMacaddr());
			networkInterface.setMtu(net.getMTU());
			networkInterface.setSpeedBPS(net.getSpeed());

			final List<String> ipV4Address = Lists.newArrayList();
			Collections.addAll(ipV4Address, net.getIPv4addr());
			networkInterface.setIpV4Address(ipV4Address);

			final List<String> ipV6Address = Lists.newArrayList();
			Collections.addAll(ipV6Address, net.getIPv6addr());
			networkInterface.setIpV6Address(ipV6Address);

			if(this.hasData(net)){
				networkInterface.setPacketsRecv(net.getPacketsRecv());
				networkInterface.setBytesRecv(net.getBytesRecv());
				networkInterface.setInputErrors(net.getInErrors());
				networkInterface.setPacketsSent(net.getPacketsSent());
				networkInterface.setBytesSent(net.getBytesSent());
				networkInterface.setOutputErrors(net.getOutErrors());
			}

			networkInterfaces.add(networkInterface);

		}

		networkInfo.setNetworkInterfaces(networkInterfaces);
	}

	private boolean hasData(final NetworkIF net){
		return net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
				|| net.getPacketsSent() > 0;
	}
}
