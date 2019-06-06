package com.k8s.xmetrics.model.hardware;

import java.util.List;

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

	private long cpuUser;
	private long cpuNice;
	private long cpuSys;
	private long cpuIdle;
	private long cpuIOWait;
	private long cpuIRQ;
	private long cpuSoftIRQ;
	private long cpuSteal;
	private long totalCPU;

	private double cpuUserPercent;
	private double cpuNicePercent;
	private double cpuSysPercent;
	private double cpuIdlePercent;
	private double cpuIOWaitPercent;
	private double cpuIRQPercent;
	private double cpuSoftIRQPercent;
	private double cpuStealPercent;

	private double cpuLoadPercentCountingTicks;
	private double cpuLoadPercentOSMXBean;

	private List<Double> cpuLoadAverages;
	private List<Double> cpuLoadPercentProcessors;

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

	public long getCpuUser() {
		return this.cpuUser;
	}

	public void setCpuUser(final long cpuUser) {
		this.cpuUser = cpuUser;
	}

	public long getCpuNice() {
		return this.cpuNice;
	}

	public void setCpuNice(final long cpuNice) {
		this.cpuNice = cpuNice;
	}

	public long getCpuSys() {
		return this.cpuSys;
	}

	public void setCpuSys(final long cpuSys) {
		this.cpuSys = cpuSys;
	}

	public long getCpuIdle() {
		return this.cpuIdle;
	}

	public void setCpuIdle(final long cpuIdle) {
		this.cpuIdle = cpuIdle;
	}

	public long getCpuIOWait() {
		return this.cpuIOWait;
	}

	public void setCpuIOWait(final long cpuIOWait) {
		this.cpuIOWait = cpuIOWait;
	}

	public long getCpuIRQ() {
		return this.cpuIRQ;
	}

	public void setCpuIRQ(final long cpuIRQ) {
		this.cpuIRQ = cpuIRQ;
	}

	public long getCpuSoftIRQ() {
		return this.cpuSoftIRQ;
	}

	public void setCpuSoftIRQ(final long cpuSoftIRQ) {
		this.cpuSoftIRQ = cpuSoftIRQ;
	}

	public long getCpuSteal() {
		return this.cpuSteal;
	}

	public void setCpuSteal(final long cpuSteal) {
		this.cpuSteal = cpuSteal;
	}

	public long getTotalCPU() {
		return this.totalCPU;
	}

	public void setTotalCPU(final long totalCPU) {
		this.totalCPU = totalCPU;
	}

	public double getCpuUserPercent() {
		return this.cpuUserPercent;
	}

	public void setCpuUserPercent(final double cpuUserPercent) {
		this.cpuUserPercent = cpuUserPercent;
	}

	public double getCpuNicePercent() {
		return this.cpuNicePercent;
	}

	public void setCpuNicePercent(final double cpuNicePercent) {
		this.cpuNicePercent = cpuNicePercent;
	}

	public double getCpuSysPercent() {
		return this.cpuSysPercent;
	}

	public void setCpuSysPercent(final double cpuSysPercent) {
		this.cpuSysPercent = cpuSysPercent;
	}

	public double getCpuIdlePercent() {
		return this.cpuIdlePercent;
	}

	public void setCpuIdlePercent(final double cpuIdlePercent) {
		this.cpuIdlePercent = cpuIdlePercent;
	}

	public double getCpuIOWaitPercent() {
		return this.cpuIOWaitPercent;
	}

	public void setCpuIOWaitPercent(final double cpuIOWaitPercent) {
		this.cpuIOWaitPercent = cpuIOWaitPercent;
	}

	public double getCpuIRQPercent() {
		return this.cpuIRQPercent;
	}

	public void setCpuIRQPercent(final double cpuIRQPercent) {
		this.cpuIRQPercent = cpuIRQPercent;
	}

	public double getCpuSoftIRQPercent() {
		return this.cpuSoftIRQPercent;
	}

	public void setCpuSoftIRQPercent(final double cpuSoftIRQPercent) {
		this.cpuSoftIRQPercent = cpuSoftIRQPercent;
	}

	public double getCpuStealPercent() {
		return this.cpuStealPercent;
	}

	public void setCpuStealPercent(final double cpuStealPercent) {
		this.cpuStealPercent = cpuStealPercent;
	}

	public double getCpuLoadPercentCountingTicks() {
		return this.cpuLoadPercentCountingTicks;
	}

	public void setCpuLoadPercentCountingTicks(final double cpuLoadPercentCountingTicks) {
		this.cpuLoadPercentCountingTicks = cpuLoadPercentCountingTicks;
	}

	public double getCpuLoadPercentOSMXBean() {
		return this.cpuLoadPercentOSMXBean;
	}

	public void setCpuLoadPercentOSMXBean(final double cpuLoadPercentOSMXBean) {
		this.cpuLoadPercentOSMXBean = cpuLoadPercentOSMXBean;
	}

	public List<Double> getCpuLoadAverages() {
		return this.cpuLoadAverages;
	}

	public void setCpuLoadAverages(final List<Double> cpuLoadAverages) {
		this.cpuLoadAverages = cpuLoadAverages;
	}

	public List<Double> getCpuLoadPercentProcessors() {
		return this.cpuLoadPercentProcessors;
	}

	public void setCpuLoadPercentProcessors(final List<Double> cpuLoadPercentProcessors) {
		this.cpuLoadPercentProcessors = cpuLoadPercentProcessors;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final CPUInfo cpuInfo = (CPUInfo) o;

		if (this.identifier != null ? !this.identifier.equals(cpuInfo.identifier) : cpuInfo.identifier != null)
			return false;
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
		sb.append(", cpuUser=").append(this.cpuUser);
		sb.append(", cpuNice=").append(this.cpuNice);
		sb.append(", cpuSys=").append(this.cpuSys);
		sb.append(", cpuIdle=").append(this.cpuIdle);
		sb.append(", cpuIOWait=").append(this.cpuIOWait);
		sb.append(", cpuIRQ=").append(this.cpuIRQ);
		sb.append(", cpuSoftIRQ=").append(this.cpuSoftIRQ);
		sb.append(", cpuSteal=").append(this.cpuSteal);
		sb.append(", totalCPU=").append(this.totalCPU);
		sb.append(", cpuUserPercent=").append(this.cpuUserPercent);
		sb.append(", cpuNicePercent=").append(this.cpuNicePercent);
		sb.append(", cpuSysPercent=").append(this.cpuSysPercent);
		sb.append(", cpuIdlePercent=").append(this.cpuIdlePercent);
		sb.append(", cpuIOWaitPercent=").append(this.cpuIOWaitPercent);
		sb.append(", cpuIRQPercent=").append(this.cpuIRQPercent);
		sb.append(", cpuSoftIRQPercent=").append(this.cpuSoftIRQPercent);
		sb.append(", cpuStealPercent=").append(this.cpuStealPercent);
		sb.append(", cpuLoadPercentCountingTicks=").append(this.cpuLoadPercentCountingTicks);
		sb.append(", cpuLoadPercentOSMXBean=").append(this.cpuLoadPercentOSMXBean);
		sb.append(", cpuLoadAverages=").append(this.cpuLoadAverages);
		sb.append(", cpuLoadPercentProcessors=").append(this.cpuLoadPercentProcessors);
		sb.append('}');
		return sb.toString();
	}
}
