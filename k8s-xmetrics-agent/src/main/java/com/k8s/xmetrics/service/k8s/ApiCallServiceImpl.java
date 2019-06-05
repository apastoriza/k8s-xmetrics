package com.k8s.xmetrics.service.k8s;

import com.squareup.okhttp.Call;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.ApiResponse;
import io.kubernetes.client.Pair;
import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author apastoriza
 */
public class ApiCallServiceImpl implements ApiCallService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiCallServiceImpl.class);
	private ApiClientService apiClientService;

	@Override
	public <T> T getData(final String url, final Type localVarReturnType) throws ApiException {
		final ApiClient apiClient = this.apiClientService.getApiClient();
		final Call call = this.composeCall(apiClient, url);
		final ApiResponse<T> response = apiClient.execute(call, localVarReturnType);
		if (response != null) {
			LOGGER.debug("response = {}", response.getData());
		} else {
			LOGGER.error("Null response for URL: '{}'", url);
		}
		return response.getData();
	}


	private Call composeCall(final ApiClient apiClient, final String url) throws ApiException {

		final List<Pair> localVarQueryParams = new ArrayList<Pair>();
		final List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

		final Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		final Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = {
				MediaType.APPLICATION_JSON_VALUE
		};
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) localVarHeaderParams.put(HttpHeaders.ACCEPT, localVarAccept);

		final String[] localVarContentTypes = {
				"*/*"
		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put(HttpHeaders.CONTENT_TYPE, localVarContentType);

		final String[] localVarAuthNames = new String[]{"BearerToken"};
		return apiClient.buildCall(url, HttpMethod.GET.name(), localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

	}

	public void setApiClientService(final ApiClientService apiClientService) {
		this.apiClientService = apiClientService;
	}
}
