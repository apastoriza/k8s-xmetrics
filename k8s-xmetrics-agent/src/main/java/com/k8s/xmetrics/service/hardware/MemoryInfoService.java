package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.MemoryInfo;

/**
 * @author apastoriza
 */
public interface MemoryInfoService {
	MemoryInfo readInfo();
}
