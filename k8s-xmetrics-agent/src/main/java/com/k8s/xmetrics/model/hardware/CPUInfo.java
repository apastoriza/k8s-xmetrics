package com.k8s.xmetrics.model.hardware;

/**
 * @author apastoriza
 */
public class CPUInfo {
	private String identifier;
	private String processorID;
	private int physicalPackageCount;
	private int physicalProcessorCount;
	private int logicalProcessorCount;
	private long systemUptimeInMillis;

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

	public String getProcessorID() {
		return this.processorID;
	}

	public void setProcessorID(final String processorID) {
		this.processorID = processorID;
	}

	public int getPhysicalPackageCount() {
		return this.physicalPackageCount;
	}

	public void setPhysicalPackageCount(final int physicalPackageCount) {
		this.physicalPackageCount = physicalPackageCount;
	}

	public int getPhysicalProcessorCount() {
		return this.physicalProcessorCount;
	}

	public void setPhysicalProcessorCount(final int physicalProcessorCount) {
		this.physicalProcessorCount = physicalProcessorCount;
	}

	public int getLogicalProcessorCount() {
		return this.logicalProcessorCount;
	}

	public void setLogicalProcessorCount(final int logicalProcessorCount) {
		this.logicalProcessorCount = logicalProcessorCount;
	}

	public long getSystemUptimeInMillis() {
		return this.systemUptimeInMillis;
	}

	public void setSystemUptimeInMillis(final long systemUptimeInMillis) {
		this.systemUptimeInMillis = systemUptimeInMillis;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final CPUInfo cpuInfo = (CPUInfo) o;

		if (this.identifier != null ? !this.identifier.equals(cpuInfo.identifier) : cpuInfo.identifier != null) return false;
		return this.processorID != null ? this.processorID.equals(cpuInfo.processorID) : cpuInfo.processorID == null;
	}

	@Override
	public int hashCode() {
		int result = this.identifier != null ? this.identifier.hashCode() : 0;
		result = 31 * result + (this.processorID != null ? this.processorID.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CPUInfo{");
		sb.append("identifier='").append(this.identifier).append('\'');
		sb.append(", processorID='").append(this.processorID).append('\'');
		sb.append(", physicalPackageCount=").append(this.physicalPackageCount);
		sb.append(", physicalProcessorCount=").append(this.physicalProcessorCount);
		sb.append(", logicalProcessorCount=").append(this.logicalProcessorCount);
		sb.append(", systemUptimeInMillis=").append(this.systemUptimeInMillis);
		sb.append('}');
		return sb.toString();
	}
}
