package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.vo.AbstractAgentVO;

import java.util.Collection;

/**
 * @author apastoriza
 */
public class NetworkInfoVO extends AbstractAgentVO {
	private String hostname;
	private String domainName;
	private String ipV4DefaultGateway;
	private String ipV6DefaultGateway;
	private Collection<NetworkInterfaceVO> networkInterfaces;

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(final String hostname) {
		this.hostname = hostname;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(final String domainName) {
		this.domainName = domainName;
	}

	public String getIpV4DefaultGateway() {
		return this.ipV4DefaultGateway;
	}

	public void setIpV4DefaultGateway(final String ipV4DefaultGateway) {
		this.ipV4DefaultGateway = ipV4DefaultGateway;
	}

	public String getIpV6DefaultGateway() {
		return this.ipV6DefaultGateway;
	}

	public void setIpV6DefaultGateway(final String ipV6DefaultGateway) {
		this.ipV6DefaultGateway = ipV6DefaultGateway;
	}

	public Collection<NetworkInterfaceVO> getNetworkInterfaces() {
		return this.networkInterfaces;
	}

	public void setNetworkInterfaces(final Collection<NetworkInterfaceVO> networkInterfaces) {
		this.networkInterfaces = networkInterfaces;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NetworkInfoVO{");
		sb.append("hostname='").append(this.hostname).append('\'');
		sb.append(", domainName='").append(this.domainName).append('\'');
		sb.append(", ipV4DefaultGateway='").append(this.ipV4DefaultGateway).append('\'');
		sb.append(", ipV6DefaultGateway='").append(this.ipV6DefaultGateway).append('\'');
		sb.append(", networkInterfaces=").append(this.networkInterfaces);
		sb.append('}');
		return sb.toString();
	}
}
