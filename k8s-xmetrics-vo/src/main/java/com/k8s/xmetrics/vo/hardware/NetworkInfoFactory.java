package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.model.hardware.NetworkInfo;
import com.k8s.xmetrics.model.hardware.NetworkInterface;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

import java.util.Collection;

/**
 * @author apastoriza
 */
public class NetworkInfoFactory extends AbstractAgentVOFactory<NetworkInfo, NetworkInfoVO> {
	private NetworkInterfaceFactory networkInterfaceFactory;

	@Override
	protected NetworkInfoVO doVO(final NetworkInfo model) {
		final Collection<NetworkInterfaceVO> networkInterfaces = this.networkInterfaceFactory.toVOs(model.getNetworkInterfaces());
		final NetworkInfoVO vo = new NetworkInfoVO();
		vo.setHostname(model.getHostname());
		vo.setDomainName(model.getDomainName());
		vo.setIpV4DefaultGateway(model.getIpV4DefaultGateway());
		vo.setIpV6DefaultGateway(model.getIpV6DefaultGateway());
		vo.setNetworkInterfaces(networkInterfaces);
		return vo;
	}

	@Override
	protected NetworkInfo doModel(final NetworkInfoVO vo) {
		final Collection<NetworkInterface> networkInterfaces = this.networkInterfaceFactory.toModels(vo.getNetworkInterfaces());
		final NetworkInfo model = new NetworkInfo();
		model.setHostname(vo.getHostname());
		model.setDomainName(vo.getDomainName());
		model.setIpV4DefaultGateway(vo.getIpV4DefaultGateway());
		model.setIpV6DefaultGateway(vo.getIpV6DefaultGateway());
		model.setNetworkInterfaces(networkInterfaces);
		return model;
	}

	public void setNetworkInterfaceFactory(final NetworkInterfaceFactory networkInterfaceFactory) {
		this.networkInterfaceFactory = networkInterfaceFactory;
	}
}
