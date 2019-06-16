package com.k8s.xmetrics.vo.k8s;

import com.k8s.xmetrics.datetime.DateTimeUtils;
import com.k8s.xmetrics.model.k8s.Metadata;
import com.k8s.xmetrics.model.k8s.NodeMetrics;
import com.k8s.xmetrics.model.k8s.Usage;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

/**
 * @author apastoriza
 */
public class NodeMetricsFactory extends AbstractAgentVOFactory<NodeMetrics, NodeMetricsVO> {
	private UsageFactory usageFactory;

	@Override
	protected NodeMetricsVO doVO(final NodeMetrics model) {
		final NodeMetricsVO vo = new NodeMetricsVO();
		final String name = model.getMetadata().getName();
		final UsageVO usageVO = this.usageFactory.toVO(model.getUsage());
		vo.setName(name);
		vo.setUsage(usageVO);
		return vo;
	}

	@Override
	protected NodeMetrics doModel(final NodeMetricsVO vo) {
		final NodeMetrics model = new NodeMetrics();
		final String timestamp = DateTimeUtils.nowAsIsoDateTimeString();

		final Metadata metadata = new Metadata();
		metadata.setCreationTimestamp(timestamp);
		metadata.setName(vo.getName());

		model.setTimestamp(timestamp);

		final Usage usage = this.usageFactory.toModel(vo.getUsage());
		model.setUsage(usage);

		return model;
	}

	public void setUsageFactory(final UsageFactory usageFactory) {
		this.usageFactory = usageFactory;
	}
}
