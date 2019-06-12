package com.k8s.xmetrics.model.k8s;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author apastoriza
 */
@ApiModel(description = "A single node of the metrics")
public class NodeMetrics {
	@SerializedName("apiVersion")
	private String apiVersion;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("window")
	private String window;

	@SerializedName("usage")
	private Usage usage;

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
		sb.append("apiVersion='").append(this.apiVersion).append('\'');
		sb.append(", metadata=").append(this.metadata);
		sb.append(", timestamp='").append(this.timestamp).append('\'');
		sb.append(", window='").append(this.window).append('\'');
		sb.append(", usage=").append(this.usage);
		sb.append('}');
		return sb.toString();
	}
}
