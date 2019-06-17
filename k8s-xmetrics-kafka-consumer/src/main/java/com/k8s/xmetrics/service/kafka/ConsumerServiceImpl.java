package com.k8s.xmetrics.service.kafka;

import com.google.common.collect.Lists;
import com.k8s.xmetrics.service.config.KafkaConfigurationService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.Executors;

/**
 * @author apastoriza
 */
public class ConsumerServiceImpl implements ConsumerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceImpl.class);
	private KafkaConfigurationService kafkaConfigurationService;

	private Collection<String> topics;

	private Long sessionTimeoutInMillis;

	public ConsumerServiceImpl() {
		this.topics = Lists.newArrayList();
	}


	public void initMethod() {
		final Properties props = new Properties();

		final String kafkaServerUrl = this.kafkaConfigurationService.getKafkaServerUrl();
		final Integer kafkaServerPort = this.kafkaConfigurationService.getKafkaServerPort();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerUrl + ":" + kafkaServerPort);

		final String groupID = this.kafkaConfigurationService.getKafkaGroupID();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupID);

		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "K8S XMetrics Producer");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, String.valueOf(Boolean.FALSE));
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, String.valueOf(this.sessionTimeoutInMillis));
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class.getName());


		Executors.newSingleThreadExecutor().execute(new ConsumerServiceRunnable(props, this.topics));
		LOGGER.warn("Kafka consumer initialized: {}", props);
	}


	public void setKafkaConfigurationService(final KafkaConfigurationService kafkaConfigurationService) {
		this.kafkaConfigurationService = kafkaConfigurationService;
	}

	public void setSessionTimeoutInMillis(final Long sessionTimeoutInMillis) {
		this.sessionTimeoutInMillis = sessionTimeoutInMillis;
	}

	public void setTopics(final Collection<String> topics) {
		this.topics = topics;
	}
}
