package com.k8s.xmetrics.service.k8s;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author apastoriza
 */
public class ApiClientServiceImpl implements ApiClientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiClientServiceImpl.class);
	private ApiClient apiClient;
	private long httpReadTimeoutInMillis;

	@Override
	public ApiClient getApiClient() {
		if (this.apiClient == null) {
			try {
				this.apiClient = Config.defaultClient();
				this.apiClient.getHttpClient().setReadTimeout(this.httpReadTimeoutInMillis, TimeUnit.MILLISECONDS);
				Configuration.setDefaultApiClient(this.apiClient);
			} catch (final IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return this.apiClient;
	}

	public void setHttpReadTimeoutInMillis(final long httpReadTimeoutInMillis) {
		this.httpReadTimeoutInMillis = httpReadTimeoutInMillis;
	}
}
