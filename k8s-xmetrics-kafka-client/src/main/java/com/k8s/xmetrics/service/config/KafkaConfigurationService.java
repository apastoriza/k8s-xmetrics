package com.k8s.xmetrics.service.config;

/**
 * @author apastoriza
 */
public interface KafkaConfigurationService {
	String getKafkaServerUrl();
	Integer getKafkaServerPort();
}
