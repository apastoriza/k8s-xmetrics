package com.k8s.xmetrics.vo;

/**
 * @author apastoriza
 */
public abstract class AbstractAgentVO {
	private String agentID;
	private Long eventTimeInMillis;

	public String getAgentID() {
		return this.agentID;
	}

	public void setAgentID(final String agentID) {
		this.agentID = agentID;
	}

	public Long getEventTimeInMillis() {
		return this.eventTimeInMillis;
	}

	public void setEventTimeInMillis(final Long eventTimeInMillis) {
		this.eventTimeInMillis = eventTimeInMillis;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractAgentVO{");
		sb.append("agentID='").append(this.agentID).append('\'');
		sb.append(", eventTimeInMillis=").append(this.eventTimeInMillis);
		sb.append('}');
		return sb.toString();
	}
}
