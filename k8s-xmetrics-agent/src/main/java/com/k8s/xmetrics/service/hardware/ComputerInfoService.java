package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.ComputerInfo;

/**
 * @author apastoriza
 */
public interface ComputerInfoService {
	ComputerInfo readInfo();
}
