package com.k8s.xmetrics.model.k8s;

/**
 * @author apastoriza
 */
public class Usage {
	private String cpu;
	private String memory;

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(final String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return this.memory;
	}

	public void setMemory(final String memory) {
		this.memory = memory;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final Usage usage = (Usage) o;

		if (this.cpu != null ? !this.cpu.equals(usage.cpu) : usage.cpu != null) return false;
		return this.memory != null ? this.memory.equals(usage.memory) : usage.memory == null;
	}

	@Override
	public int hashCode() {
		int result = this.cpu != null ? this.cpu.hashCode() : 0;
		result = 31 * result + (this.memory != null ? this.memory.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Usage{");
		sb.append("cpu='").append(this.cpu).append('\'');
		sb.append(", memory='").append(this.memory).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
