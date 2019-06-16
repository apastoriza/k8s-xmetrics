package com.k8s.xmetrics.vo.k8s;

import com.k8s.xmetrics.vo.AbstractAgentVO;

import java.util.Collection;

/**
 * @author apastoriza
 */
public class PodMetricsVO extends AbstractAgentVO {
	private String name;
	private Collection<ContainerVO> containers;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Collection<ContainerVO> getContainers() {
		return this.containers;
	}

	public void setContainers(final Collection<ContainerVO> containers) {
		this.containers = containers;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PodMetricsVO{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", containers=").append(this.containers);
		sb.append('}');
		return sb.toString();
	}
}
