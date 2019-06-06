package com.k8s.xmetrics.model.hardware;

import java.util.List;

/**
 * @author apastoriza
 */
public class NetworkInterface {
	private String name;
	private String displayName;
	private String macAddress;
	private int mtu;
	private long speedBPS;
	private List<String> ipV4Address;
	private List<String> ipV6Address;
	private long packetsRecv;
	private long bytesRecv;
	private long inputErrors;
	private long packetsSent;
	private long bytesSent;
	private long outputErrors;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	public String getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(final String macAddress) {
		this.macAddress = macAddress;
	}

	public int getMtu() {
		return this.mtu;
	}

	public void setMtu(final int mtu) {
		this.mtu = mtu;
	}

	public long getSpeedBPS() {
		return this.speedBPS;
	}

	public void setSpeedBPS(final long speedBPS) {
		this.speedBPS = speedBPS;
	}

	public List<String> getIpV4Address() {
		return this.ipV4Address;
	}

	public void setIpV4Address(final List<String> ipV4Address) {
		this.ipV4Address = ipV4Address;
	}

	public List<String> getIpV6Address() {
		return this.ipV6Address;
	}

	public void setIpV6Address(final List<String> ipV6Address) {
		this.ipV6Address = ipV6Address;
	}

	public long getPacketsRecv() {
		return this.packetsRecv;
	}

	public void setPacketsRecv(final long packetsRecv) {
		this.packetsRecv = packetsRecv;
	}

	public long getBytesRecv() {
		return this.bytesRecv;
	}

	public void setBytesRecv(final long bytesRecv) {
		this.bytesRecv = bytesRecv;
	}

	public long getInputErrors() {
		return this.inputErrors;
	}

	public void setInputErrors(final long inputErrors) {
		this.inputErrors = inputErrors;
	}

	public long getPacketsSent() {
		return this.packetsSent;
	}

	public void setPacketsSent(final long packetsSent) {
		this.packetsSent = packetsSent;
	}

	public long getBytesSent() {
		return this.bytesSent;
	}

	public void setBytesSent(final long bytesSent) {
		this.bytesSent = bytesSent;
	}

	public long getOutputErrors() {
		return this.outputErrors;
	}

	public void setOutputErrors(final long outputErrors) {
		this.outputErrors = outputErrors;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final NetworkInterface that = (NetworkInterface) o;

		return this.macAddress != null ? this.macAddress.equals(that.macAddress) : that.macAddress == null;
	}

	@Override
	public int hashCode() {
		return this.macAddress != null ? this.macAddress.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NetworkInterface{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", displayName='").append(this.displayName).append('\'');
		sb.append(", macAddress='").append(this.macAddress).append('\'');
		sb.append(", mtu=").append(this.mtu);
		sb.append(", speedBPS=").append(this.speedBPS);
		sb.append(", ipV4Address=").append(this.ipV4Address);
		sb.append(", ipV6Address=").append(this.ipV6Address);
		sb.append(", packetsRecv=").append(this.packetsRecv);
		sb.append(", bytesRecv=").append(this.bytesRecv);
		sb.append(", inputErrors=").append(this.inputErrors);
		sb.append(", packetsSent=").append(this.packetsSent);
		sb.append(", bytesSent=").append(this.bytesSent);
		sb.append(", outputErrors=").append(this.outputErrors);
		sb.append('}');
		return sb.toString();
	}
}
