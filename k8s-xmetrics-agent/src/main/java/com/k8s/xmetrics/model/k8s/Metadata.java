package com.k8s.xmetrics.model.k8s;

/**
 * @author apastoriza
 */
public class Metadata {
	private String name;
	private String selfLink;
	private String creationTimestamp;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSelfLink() {
		return this.selfLink;
	}

	public void setSelfLink(final String selfLink) {
		this.selfLink = selfLink;
	}

	public String getCreationTimestamp() {
		return this.creationTimestamp;
	}

	public void setCreationTimestamp(final String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final Metadata metadata = (Metadata) o;

		if (this.name != null ? !this.name.equals(metadata.name) : metadata.name != null) return false;
		if (this.selfLink != null ? !this.selfLink.equals(metadata.selfLink) : metadata.selfLink != null) return false;
		return this.creationTimestamp != null ? this.creationTimestamp.equals(metadata.creationTimestamp) : metadata.creationTimestamp == null;
	}

	@Override
	public int hashCode() {
		int result = this.name != null ? this.name.hashCode() : 0;
		result = 31 * result + (this.selfLink != null ? this.selfLink.hashCode() : 0);
		result = 31 * result + (this.creationTimestamp != null ? this.creationTimestamp.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Metadata{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", selfLink='").append(this.selfLink).append('\'');
		sb.append(", creationTimestamp='").append(this.creationTimestamp).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
