package com.k8s.xmetrics.service.k8s;

import io.kubernetes.client.ApiException;

import java.lang.reflect.Type;

/**
 * @author apastoriza
 */
public interface ApiCallService {
	<T> T getData(String url, Type localVarReturnType) throws ApiException;
}
