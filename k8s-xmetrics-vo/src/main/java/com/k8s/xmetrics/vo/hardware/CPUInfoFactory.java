package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.model.hardware.CPUInfo;
import com.k8s.xmetrics.vo.AbstractAgentVOFactory;

import java.util.List;

/**
 * @author apastoriza
 */
public class CPUInfoFactory extends AbstractAgentVOFactory<CPUInfo, CPUInfoVO> {

	@Override
	protected CPUInfoVO doVO(final CPUInfo model) {
		final CPUInfoVO vo = new CPUInfoVO();
		vo.setIdentifier(model.getIdentifier());
		vo.setProcessorID(model.getProcessorID());
		vo.setPhysicalPackageCount(model.getPhysicalPackageCount());
		vo.setPhysicalProcessorCount(model.getPhysicalProcessorCount());
		vo.setLogicalProcessorCount(model.getLogicalProcessorCount());
		vo.setSystemUptimeInMillis(model.getSystemUptimeInMillis());

		vo.setCpuUser(model.getCpuUser());
		vo.setCpuNice(model.getCpuNice());
		vo.setCpuSys(model.getCpuSys());
		vo.setCpuIdle(model.getCpuIdle());
		vo.setCpuIOWait(model.getCpuIOWait());
		vo.setCpuIRQ(model.getCpuIRQ());
		vo.setCpuSoftIRQ(model.getCpuSoftIRQ());
		vo.setCpuSteal(model.getCpuSteal());
		vo.setTotalCPU(model.getTotalCPU());

		vo.setCpuUserPercent(model.getCpuUserPercent());
		vo.setCpuNicePercent(model.getCpuNicePercent());
		vo.setCpuSysPercent(model.getCpuSysPercent());
		vo.setCpuIdlePercent(model.getCpuIdlePercent());
		vo.setCpuIOWaitPercent(model.getCpuIOWaitPercent());
		vo.setCpuIRQPercent(model.getCpuIRQPercent());
		vo.setCpuSoftIRQPercent(model.getCpuSoftIRQPercent());
		vo.setCpuStealPercent(model.getCpuStealPercent());

		vo.setCpuLoadPercentCountingTicks(model.getCpuLoadPercentCountingTicks());
		vo.setCpuLoadPercentOSMXBean(model.getCpuLoadPercentOSMXBean());

		vo.setCpuLoadAverages(model.getCpuLoadAverages());
		vo.setCpuLoadPercentProcessors(model.getCpuLoadPercentProcessors());
		return vo;
	}

	@Override
	protected CPUInfo doModel(final CPUInfoVO vo) {

		final CPUInfo model = new CPUInfo();
		model.setIdentifier(vo.getIdentifier());
		model.setProcessorID(vo.getProcessorID());
		model.setPhysicalPackageCount(vo.getPhysicalPackageCount());
		model.setPhysicalProcessorCount(vo.getPhysicalProcessorCount());
		model.setLogicalProcessorCount(vo.getLogicalProcessorCount());
		model.setSystemUptimeInMillis(vo.getSystemUptimeInMillis());

		model.setCpuUser(vo.getCpuUser());
		model.setCpuNice(vo.getCpuNice());
		model.setCpuSys(vo.getCpuSys());
		model.setCpuIdle(vo.getCpuIdle());
		model.setCpuIOWait(vo.getCpuIOWait());
		model.setCpuIRQ(vo.getCpuIRQ());
		model.setCpuSoftIRQ(vo.getCpuSoftIRQ());
		model.setCpuSteal(vo.getCpuSteal());
		model.setTotalCPU(vo.getTotalCPU());

		model.setCpuUserPercent(vo.getCpuUserPercent());
		model.setCpuNicePercent(vo.getCpuNicePercent());
		model.setCpuSysPercent(vo.getCpuSysPercent());
		model.setCpuIdlePercent(vo.getCpuIdlePercent());
		model.setCpuIOWaitPercent(vo.getCpuIOWaitPercent());
		model.setCpuIRQPercent(vo.getCpuIRQPercent());
		model.setCpuSoftIRQPercent(vo.getCpuSoftIRQPercent());
		model.setCpuStealPercent(vo.getCpuStealPercent());

		model.setCpuLoadPercentCountingTicks(vo.getCpuLoadPercentCountingTicks());
		model.setCpuLoadPercentOSMXBean(vo.getCpuLoadPercentOSMXBean());

		model.setCpuLoadAverages(vo.getCpuLoadAverages());
		model.setCpuLoadPercentProcessors(vo.getCpuLoadPercentProcessors());
		return model;

	}
}
