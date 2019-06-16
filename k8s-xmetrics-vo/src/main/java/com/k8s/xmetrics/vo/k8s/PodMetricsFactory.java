package com.k8s.xmetrics.vo.k8s;

import com.k8s.xmetrics.datetime.DateTimeUtils;
import com.k8s.xmetrics.model.k8s.Container;
import com.k8s.xmetrics.model.k8s.Metadata;
import com.k8s.xmetrics.model.k8s.PodMetrics;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

import java.util.Collection;

/**
 * @author apastoriza
 */
public class PodMetricsFactory extends AbstractAgentVOFactory<PodMetrics, PodMetricsVO> {
	private ContainerFactory containerFactory;

	@Override
	protected PodMetricsVO doVO(final PodMetrics model) {
		final PodMetricsVO vo = new PodMetricsVO();
		vo.setName(model.getMetadata().getName());
		final Collection<ContainerVO> containers = this.containerFactory.toVOs(model.getContainers());
		vo.setContainers(containers);
		return vo;
	}

	@Override
	protected PodMetrics doModel(final PodMetricsVO vo) {
		final PodMetrics model = new PodMetrics();
		final String timestamp = DateTimeUtils.nowAsIsoDateTimeString();

		final Metadata metadata = new Metadata();
		metadata.setCreationTimestamp(timestamp);
		metadata.setName(vo.getName());

		model.setTimestamp(timestamp);

		final Collection<Container> containers = this.containerFactory.toModels(vo.getContainers());
		model.setContainers(containers);

		return model;
	}

	public void setContainerFactory(final ContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}
}
