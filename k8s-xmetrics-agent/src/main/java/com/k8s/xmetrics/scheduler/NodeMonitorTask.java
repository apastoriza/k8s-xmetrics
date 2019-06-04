package com.k8s.xmetrics.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import com.k8s.xmetrics.service.RestTemplateService;
import com.k8s.xmetrics.util.ObjectMapperFactory;
import com.squareup.okhttp.Call;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.ApiResponse;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.Pair;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author apastoriza
 */
public class NodeMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeMonitorTask.class);

	private final ObjectMapper mapper;
	private RestTemplateService restTemplateService;
	private String host;
	private String link;

	public NodeMonitorTask() {
		this.mapper = ObjectMapperFactory.create();
	}

	@Override
	public void run() {
		LOGGER.warn("Running node update....");
		this.monitor();
	}

	private void monitor() {
		try {
			final ApiClient client = Config.defaultClient();
			client.getHttpClient().setReadTimeout(0, TimeUnit.SECONDS); // infinite timeout
			Configuration.setDefaultApiClient(client);

			final CoreV1Api api = new CoreV1Api();


			final Call call = this.composeCall(client);
			final Type localVarReturnType = new TypeToken<V1PodList>() {
			}.getType();
			final ApiResponse<V1PodList> response = client.execute(call, localVarReturnType);
			LOGGER.error("response = {}", response.getData());


		} catch (final IOException | ApiException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private Call composeCall(final ApiClient apiClient) throws ApiException {
		final Object localVarPostBody = null;

		// create path and map variables
		final String localVarPath = "/apis/metrics.k8s.io/v1beta1/nodes";

		final List<Pair> localVarQueryParams = new ArrayList<Pair>();
		final List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

		final Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		final Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = {
				"application/json", "application/yaml", "application/vnd.kubernetes.protobuf", "application/json;stream=watch", "application/vnd.kubernetes.protobuf;stream=watch"
		};
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {
				"*/*"
		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		final String[] localVarAuthNames = new String[]{"BearerToken"};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
	}

	public void setRestTemplateService(final RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public void setLink(final String link) {
		this.link = link;
	}
}
