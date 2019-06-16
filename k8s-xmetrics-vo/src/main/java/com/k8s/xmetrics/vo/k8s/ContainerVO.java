package com.k8s.xmetrics.vo.k8s;

/**
 * @author apastoriza
 */
public class ContainerVO {
	private String name;
	private UsageVO usage;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public UsageVO getUsage() {
		return this.usage;
	}

	public void setUsage(final UsageVO usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ContainerVO{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", usage=").append(this.usage);
		sb.append('}');
		return sb.toString();
	}
}
