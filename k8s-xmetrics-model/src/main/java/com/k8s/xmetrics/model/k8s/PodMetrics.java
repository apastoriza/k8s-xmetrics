package com.k8s.xmetrics.model.k8s;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author apastoriza
 */
@ApiModel(description = "A single pod of the metrics")
public class PodMetrics {
	@SerializedName("apiVersion")
	private String apiVersion;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("window")
	private String window;

	@SerializedName("containers")
	private List<Container> containers;

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

	public List<Container> getContainers() {
		return this.containers;
	}

	public void setContainers(final List<Container> containers) {
		this.containers = containers;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final PodMetrics that = (PodMetrics) o;

		return this.metadata != null ? this.metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		return this.metadata != null ? this.metadata.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PodMetrics{");
		sb.append("apiVersion='").append(this.apiVersion).append('\'');
		sb.append(", metadata=").append(this.metadata);
		sb.append(", timestamp='").append(this.timestamp).append('\'');
		sb.append(", window='").append(this.window).append('\'');
		sb.append(", containers=").append(this.containers);
		sb.append('}');
		return sb.toString();
	}
}
