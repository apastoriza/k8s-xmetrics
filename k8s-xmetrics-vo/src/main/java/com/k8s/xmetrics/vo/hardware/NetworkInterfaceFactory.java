package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.model.hardware.NetworkInterface;
import com.k8s.xmetrics.vo.AbstractVOFactory;

import java.util.List;

/**
 * @author apastoriza
 */
public class NetworkInterfaceFactory extends AbstractVOFactory<NetworkInterface, NetworkInterfaceVO> {
	@Override
	protected NetworkInterfaceVO doVO(final NetworkInterface model) {
		final NetworkInterfaceVO vo = new NetworkInterfaceVO();
		vo.setName(model.getName());
		vo.setDisplayName(model.getDisplayName());
		vo.setMacAddress(model.getMacAddress());
		vo.setMtu(model.getMtu());
		vo.setSpeedBPS(model.getSpeedBPS());
		vo.setIpV4Address(model.getIpV4Address());
		vo.setIpV6Address(model.getIpV6Address());
		vo.setPacketsRecv(model.getPacketsRecv());
		vo.setBytesRecv(model.getBytesRecv());
		vo.setInputErrors(model.getInputErrors());
		vo.setPacketsSent(model.getPacketsSent());
		vo.setBytesSent(model.getBytesSent());
		vo.setOutputErrors(model.getOutputErrors());
		return vo;
	}

	@Override
	protected NetworkInterface doModel(final NetworkInterfaceVO vo) {
		final NetworkInterface model = new NetworkInterface();
		model.setName(vo.getName());
		model.setDisplayName(vo.getDisplayName());
		model.setMacAddress(vo.getMacAddress());
		model.setMtu(vo.getMtu());
		model.setSpeedBPS(vo.getSpeedBPS());
		model.setIpV4Address(vo.getIpV4Address());
		model.setIpV6Address(vo.getIpV6Address());
		model.setPacketsRecv(vo.getPacketsRecv());
		model.setBytesRecv(vo.getBytesRecv());
		model.setInputErrors(vo.getInputErrors());
		model.setPacketsSent(vo.getPacketsSent());
		model.setBytesSent(vo.getBytesSent());
		model.setOutputErrors(vo.getOutputErrors());
		return model;
	}
}
