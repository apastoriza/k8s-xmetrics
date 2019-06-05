package com.k8s.xmetrics.service.k8s;

import io.kubernetes.client.ApiClient;

/**
 * @author apastoriza
 */
public interface ApiClientService {
	ApiClient getApiClient();
}
