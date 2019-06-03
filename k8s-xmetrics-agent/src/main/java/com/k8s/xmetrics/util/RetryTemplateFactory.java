package com.k8s.xmetrics.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Collections;

/**
 * @author apastoriza
 */
public class RetryTemplateFactory {
	private static final long DELAY_IN_MILLIS = 1500L;
	private static final int MAX_RETRIES = 5;

	/**
	 * The Constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RetryTemplateFactory.class);

	public static RetryTemplate create(){
		final RetryTemplate template = new RetryTemplate();

		final SimpleRetryPolicy policy = new SimpleRetryPolicy(MAX_RETRIES, Collections.singletonMap(Exception.class, true));
		template.setRetryPolicy(policy);

		final FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		backOffPolicy.setBackOffPeriod(DELAY_IN_MILLIS);

		template.setBackOffPolicy(backOffPolicy);

		LOGGER.trace("Created retry template: {}",template);
		return template;
	}

}
