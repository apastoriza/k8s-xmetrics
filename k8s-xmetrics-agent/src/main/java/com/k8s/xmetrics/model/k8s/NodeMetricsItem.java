package com.k8s.xmetrics.model.k8s;

/**
 * @author apastoriza
 */
public class NodeMetricsItem {
	private Metadata metadata;
	private String timestamp;
	private String window;
	private Usage usage;

	public Metadata getMetadata() {
		return this.metadata;
	}

	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final String timestamp) {
		this.timestamp = timestamp;
	}

	public String getWindow() {
		return this.window;
	}

	public void setWindow(final String window) {
		this.window = window;
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

		final NodeMetricsItem that = (NodeMetricsItem) o;

		return this.metadata != null ? this.metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		return this.metadata != null ? this.metadata.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NodeMetricsItem{");
		sb.append("metadata=").append(this.metadata);
		sb.append(", timestamp='").append(this.timestamp).append('\'');
		sb.append(", window='").append(this.window).append('\'');
		sb.append(", usage=").append(this.usage);
		sb.append('}');
		return sb.toString();
	}
}
