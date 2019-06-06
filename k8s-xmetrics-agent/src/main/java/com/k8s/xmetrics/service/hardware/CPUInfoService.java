package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.CPUInfo;

/**
 * @author apastoriza
 */
public interface CPUInfoService {
	CPUInfo readInfo();
}
