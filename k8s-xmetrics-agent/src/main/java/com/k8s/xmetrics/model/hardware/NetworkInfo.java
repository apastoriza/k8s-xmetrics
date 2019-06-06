package com.k8s.xmetrics.model.hardware;

import java.util.List;

/**
 * @author apastoriza
 */
public class NetworkInfo {
	private String hostname;
	private String domainName;
	private String ipV4DefaultGateway;
	private String ipV6DefaultGateway;
	private List<NetworkInterface> networkInterfaces;

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

	public List<NetworkInterface> getNetworkInterfaces() {
		return this.networkInterfaces;
	}

	public void setNetworkInterfaces(final List<NetworkInterface> networkInterfaces) {
		this.networkInterfaces = networkInterfaces;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final NetworkInfo that = (NetworkInfo) o;

		if (this.hostname != null ? !this.hostname.equals(that.hostname) : that.hostname != null) return false;
		return this.domainName != null ? this.domainName.equals(that.domainName) : that.domainName == null;
	}

	@Override
	public int hashCode() {
		int result = this.hostname != null ? this.hostname.hashCode() : 0;
		result = 31 * result + (this.domainName != null ? this.domainName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NetworkInfo{");
		sb.append("hostname='").append(this.hostname).append('\'');
		sb.append(", domainName='").append(this.domainName).append('\'');
		sb.append(", ipV4DefaultGateway='").append(this.ipV4DefaultGateway).append('\'');
		sb.append(", ipV6DefaultGateway='").append(this.ipV6DefaultGateway).append('\'');
		sb.append(", networkInterfaces=").append(this.networkInterfaces);
		sb.append('}');
		return sb.toString();
	}
}
