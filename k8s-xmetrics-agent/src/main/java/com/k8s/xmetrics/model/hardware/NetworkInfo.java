package com.k8s.xmetrics.model.hardware;

import java.util.List;

/**
 * @author apastoriza
 */
public class NetworkInfo {
	private List<NetworkInterface> networkInterfaces;

	public List<NetworkInterface> getNetworkInterfaces() {
		return this.networkInterfaces;
	}

	public void setNetworkInterfaces(final List<NetworkInterface> networkInterfaces) {
		this.networkInterfaces = networkInterfaces;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NetworkInfo{");
		sb.append("networkInterfaces=").append(this.networkInterfaces);
		sb.append('}');
		return sb.toString();
	}
}
