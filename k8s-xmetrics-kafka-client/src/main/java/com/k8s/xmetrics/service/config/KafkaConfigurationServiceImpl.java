package com.k8s.xmetrics.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author apastoriza
 */
@Service(value = "kafkaConfigurationService")
public class KafkaConfigurationServiceImpl implements KafkaConfigurationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfigurationServiceImpl.class);

	@Value("${KAFKA_SERVER_URL:}")
	private String kafkaServerUrl;

	@Value("${KAFKA_SERVER_PORT:0}")
	private Integer kafkaServerPort;

	@Override
	public String getKafkaServerUrl() {
		String value = "localhost";
		if(this.kafkaServerUrl!=null && !this.kafkaServerUrl.isEmpty()){
			value = this.kafkaServerUrl;
		}else{
			LOGGER.warn("Undefined KAFKA_SERVER_URL. Using '{}'", value);
		}
		return value;
	}

	public Integer getKafkaServerPort() {
		Integer value = 9092;
		if(this.kafkaServerPort!=null && this.kafkaServerPort > 0){
			value = this.kafkaServerPort;
		}else{
			LOGGER.warn("Undefined KAFKA_SERVER_PORT. Using {}", value);
		}
		return value;
	}
}
