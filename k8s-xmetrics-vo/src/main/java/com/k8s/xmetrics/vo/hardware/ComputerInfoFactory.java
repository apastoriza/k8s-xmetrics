package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.model.hardware.ComputerInfo;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

/**
 * @author apastoriza
 */
public class ComputerInfoFactory extends AbstractAgentVOFactory<ComputerInfo, ComputerInfoVO> {

	@Override
	protected ComputerInfoVO doVO(final ComputerInfo model) {
		final ComputerInfoVO vo = new ComputerInfoVO();
		vo.setManufacturer(model.getManufacturer());
		vo.setModel(model.getModel());
		vo.setSerialNumber(model.getSerialNumber());
		return vo;
	}

	@Override
	protected ComputerInfo doModel(final ComputerInfoVO vo) {
		final ComputerInfo model = new ComputerInfo();
		model.setManufacturer(vo.getManufacturer());
		model.setModel(vo.getModel());
		model.setSerialNumber(vo.getSerialNumber());
		return model;
	}
}
