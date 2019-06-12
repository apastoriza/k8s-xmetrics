package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.vo.AbstractAgentVO;

/**
 * @author apastoriza
 */
public class MemoryInfoVO extends AbstractAgentVO {
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
	public String toString() {
		final StringBuilder sb = new StringBuilder("MemoryInfoVO{");
		sb.append("availableBytes=").append(this.availableBytes);
		sb.append(", totalBytes=").append(this.totalBytes);
		sb.append(", swapUsedBytes=").append(this.swapUsedBytes);
		sb.append(", swapTotalBytes=").append(this.swapTotalBytes);
		sb.append('}');
		return sb.toString();
	}
}
