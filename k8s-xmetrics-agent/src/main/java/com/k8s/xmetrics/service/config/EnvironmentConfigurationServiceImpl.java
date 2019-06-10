package com.k8s.xmetrics.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author apastoriza
 */
@Service(value = "environmentConfigurationService")
public class EnvironmentConfigurationServiceImpl implements EnvironmentConfigurationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentConfigurationServiceImpl.class);

	@Value("${KAFKA_SERVER_URL}")
	private String kafkaServerUrl;

	@Value("${KAFKA_SERVER_PORT}")
	private Integer kafkaServerPort;

	@Override
	public String getKafkaServerUrl() {
		return this.kafkaServerUrl;
	}

	public Integer getKafkaServerPort() {
		return this.kafkaServerPort;
	}
}
