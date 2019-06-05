package com.k8s.xmetrics.model.k8s;

import com.google.gson.annotations.SerializedName;

/**
 * @author apastoriza
 */
public class Container {
	@SerializedName("name")
	private String name;
	@SerializedName("usage")
	private Usage usage;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Usage getUsage() {
		return this.usage;
	}

	public void setUsage(final Usage usage) {
		this.usage = usage;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final Container container = (Container) o;

		return this.name != null ? this.name.equals(container.name) : container.name == null;
	}

	@Override
	public int hashCode() {
		return this.name != null ? this.name.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Container{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", usage=").append(this.usage);
		sb.append('}');
		return sb.toString();
	}
}
