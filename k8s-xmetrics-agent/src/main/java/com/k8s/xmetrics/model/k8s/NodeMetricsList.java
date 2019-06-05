package com.k8s.xmetrics.model.k8s;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author apastoriza
 */
@ApiModel(description = "NodeMetricsList is a list of NodeMetricsListItem")
public class NodeMetricsList {
	@SerializedName("apiVersion")
	private String apiVersion;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("items")
	private List<NodeMetricsListItem> items;

	/**
	 * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources
	 *
	 * @return apiVersion
	 **/
	@ApiModelProperty(value = "APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources")
	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(final String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public Metadata getMetadata() {
		return this.metadata;
	}

	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}

	public List<NodeMetricsListItem> getItems() {
		return this.items;
	}

	public void setItems(final List<NodeMetricsListItem> items) {
		this.items = items;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final NodeMetricsList that = (NodeMetricsList) o;

		return this.metadata != null ? this.metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		return this.metadata != null ? this.metadata.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NodeMetricsList{");
		sb.append("apiVersion='").append(this.apiVersion).append('\'');
		sb.append(", metadata=").append(this.metadata);
		sb.append(", items=").append(this.items);
		sb.append('}');
		return sb.toString();
	}
}
