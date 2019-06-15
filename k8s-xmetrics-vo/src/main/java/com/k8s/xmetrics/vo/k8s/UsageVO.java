package com.k8s.xmetrics.vo.k8s;

/**
 * @author apastoriza
 */
public class UsageVO {
	private String cpu;
	private String cpuUnits;

	private String memory;
	private String memoryUnits;

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(final String cpu) {
		this.cpu = cpu;
	}

	public String getCpuUnits() {
		return this.cpuUnits;
	}

	public void setCpuUnits(final String cpuUnits) {
		this.cpuUnits = cpuUnits;
	}

	public String getMemory() {
		return this.memory;
	}

	public void setMemory(final String memory) {
		this.memory = memory;
	}

	public String getMemoryUnits() {
		return this.memoryUnits;
	}

	public void setMemoryUnits(final String memoryUnits) {
		this.memoryUnits = memoryUnits;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UsageVO{");
		sb.append("cpu='").append(this.cpu).append('\'');
		sb.append(", cpuUnits='").append(this.cpuUnits).append('\'');
		sb.append(", memory='").append(this.memory).append('\'');
		sb.append(", memoryUnits='").append(this.memoryUnits).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
