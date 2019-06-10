package com.k8s.xmetrics.service.config;

/**
 * @author apastoriza
 */
public interface EnvironmentConfigurationService {
	String getKafkaServerUrl();
	Integer getKafkaServerPort();
}
