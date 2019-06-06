package com.k8s.xmetrics.service.hardware;

import com.k8s.xmetrics.model.hardware.NetworkInfo;

/**
 * @author apastoriza
 */
public interface NetworkInfoService {
	NetworkInfo readInfo();
}
