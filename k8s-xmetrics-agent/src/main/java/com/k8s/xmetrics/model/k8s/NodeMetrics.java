package com.k8s.xmetrics.model.k8s;

import java.util.List;

/**
 * @author apastoriza
 */
public class NodeMetrics {
	private Metadata metadata;
	private List<NodeMetricsItem> items;

	public Metadata getMetadata() {
		return this.metadata;
	}

	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}

	public List<NodeMetricsItem> getItems() {
		return this.items;
	}

	public void setItems(final List<NodeMetricsItem> items) {
		this.items = items;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final NodeMetrics that = (NodeMetrics) o;

		return this.metadata != null ? this.metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		return this.metadata != null ? this.metadata.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NodeMetrics{");
		sb.append("metadata=").append(this.metadata);
		sb.append(", items=").append(this.items);
		sb.append('}');
		return sb.toString();
	}
}
