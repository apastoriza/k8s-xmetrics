package com.k8s.xmetrics.vo.k8s;

import com.k8s.xmetrics.model.k8s.Container;
import com.k8s.xmetrics.model.k8s.Usage;
import com.k8s.xmetrics.vo.AbstractVOFactory;

/**
 * @author apastoriza
 */
public class ContainerFactory extends AbstractVOFactory<Container, ContainerVO> {
	private UsageFactory usageFactory;

	@Override
	protected ContainerVO doVO(final Container model) {
		final ContainerVO vo = new ContainerVO();
		final String name = model.getName();
		final UsageVO usageVO = this.usageFactory.toVO(model.getUsage());
		vo.setName(name);
		vo.setUsage(usageVO);
		return vo;
	}

	@Override
	protected Container doModel(final ContainerVO vo) {
		final Container model = new Container();
		model.setName(vo.getName());

		final Usage usage = this.usageFactory.doModel(vo.getUsage());
		model.setUsage(usage);

		return model;
	}

	public void setUsageFactory(final UsageFactory usageFactory) {
		this.usageFactory = usageFactory;
	}
}
