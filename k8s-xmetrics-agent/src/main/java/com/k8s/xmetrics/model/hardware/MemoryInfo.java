package com.k8s.xmetrics.model.hardware;

/**
 * @author apastoriza
 */
public class MemoryInfo {
	private long availableBytes;
	private long totalBytes;
	private long swapUsedBytes;
	private long swapTotalBytes;

	public long getAvailableBytes() {
		return this.availableBytes;
	}

	public void setAvailableBytes(final long availableBytes) {
		this.availableBytes = availableBytes;
	}

	public long getTotalBytes() {
		return this.totalBytes;
	}

	public void setTotalBytes(final long totalBytes) {
		this.totalBytes = totalBytes;
	}

	public long getSwapUsedBytes() {
		return this.swapUsedBytes;
	}

	public void setSwapUsedBytes(final long swapUsedBytes) {
		this.swapUsedBytes = swapUsedBytes;
	}

	public long getSwapTotalBytes() {
		return this.swapTotalBytes;
	}

	public void setSwapTotalBytes(final long swapTotalBytes) {
		this.swapTotalBytes = swapTotalBytes;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final MemoryInfo that = (MemoryInfo) o;

		if (this.availableBytes != that.availableBytes) return false;
		if (this.totalBytes != that.totalBytes) return false;
		if (this.swapUsedBytes != that.swapUsedBytes) return false;
		return this.swapTotalBytes == that.swapTotalBytes;
	}

	@Override
	public int hashCode() {
		int result = (int) (this.availableBytes ^ (this.availableBytes >>> 32));
		result = 31 * result + (int) (this.totalBytes ^ (this.totalBytes >>> 32));
		result = 31 * result + (int) (this.swapUsedBytes ^ (this.swapUsedBytes >>> 32));
		result = 31 * result + (int) (this.swapTotalBytes ^ (this.swapTotalBytes >>> 32));
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MemoryInfo{");
		sb.append("availableBytes=").append(this.availableBytes);
		sb.append(", totalBytes=").append(this.totalBytes);
		sb.append(", swapUsedBytes=").append(this.swapUsedBytes);
		sb.append(", swapTotalBytes=").append(this.swapTotalBytes);
		sb.append('}');
		return sb.toString();
	}
}
