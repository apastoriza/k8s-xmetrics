package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.model.hardware.MemoryInfo;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

/**
 * @author apastoriza
 */
public class MemoryInfoFactory extends AbstractAgentVOFactory<MemoryInfo, MemoryInfoVO> {
	@Override
	protected MemoryInfoVO doVO(final MemoryInfo model) {
		final MemoryInfoVO vo = new MemoryInfoVO();
		vo.setAvailableBytes(model.getAvailableBytes());
		vo.setTotalBytes(model.getSwapTotalBytes());
		vo.setSwapUsedBytes(model.getSwapUsedBytes());
		vo.setSwapTotalBytes(model.getSwapTotalBytes());
		return vo;
	}

	@Override
	protected MemoryInfo doModel(final MemoryInfoVO vo) {
		final MemoryInfo model = new MemoryInfo();
		model.setAvailableBytes(vo.getAvailableBytes());
		model.setTotalBytes(vo.getSwapTotalBytes());
		model.setSwapUsedBytes(vo.getSwapUsedBytes());
		model.setSwapTotalBytes(vo.getSwapTotalBytes());
		return model;
	}
}
