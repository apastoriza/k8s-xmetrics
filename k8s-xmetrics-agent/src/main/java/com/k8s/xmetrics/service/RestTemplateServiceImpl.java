package com.k8s.xmetrics.service;

import com.k8s.xmetrics.util.RestTemplateFactory;
import com.k8s.xmetrics.util.RetryTemplateFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author apastoriza
 */
public class RestTemplateServiceImpl implements RestTemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);
	private final RestTemplate restTemplate;
	private final RetryTemplate retryTemplate;

	public RestTemplateServiceImpl() {
		this.restTemplate = RestTemplateFactory.create();
		this.retryTemplate = RetryTemplateFactory.create();
	}

	@Override
	public String getJson(final String url) {
		final ResponseEntity<String> responseEntity = this.exchangeGet(url, String.class);
		return responseEntity.getBody();
	}


	private <T> ResponseEntity<T> exchangeGet(final String url, final Class<T> responseType) {
		try {
			final HttpEntity request = this.composeHttpEntity();
			return this.retryTemplate.execute(new RetryCallback<ResponseEntity<T>, Exception>() {
				@Override
				public ResponseEntity<T> doWithRetry(final RetryContext context) throws Exception {
					return RestTemplateServiceImpl.this.restTemplate.exchange(url, HttpMethod.GET, request, responseType);
				}
			});
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private HttpEntity composeHttpEntity() {
		final MultiValueMap<String, String> headers = composeHeaders();
		return new HttpEntity(headers);
	}


	private static MultiValueMap<String, String> composeHeaders() {
		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add(HttpHeaders.USER_AGENT, "K8S XMetrics Agent v1.0");
		return headers;
	}
}
