package com.k8s.xmetrics.service.kafka;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.k8s.xmetrics.service.config.KafkaConfigurationService;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * @author apastoriza
 */
public class ProducerServiceImpl implements ProducerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

	private KafkaConfigurationService kafkaConfigurationService;
	private KafkaProducer<String, Object> producer;
	private final ListMultimap<String, ProducerListener> producerListenerMap;

	public ProducerServiceImpl() {
		this.producerListenerMap = MultimapBuilder.treeKeys().arrayListValues().build();
	}


	public void initMethod() {
		final Properties props = new Properties();

		final String kafkaServerUrl = this.kafkaConfigurationService.getKafkaServerUrl();
		final Integer kafkaServerPort = this.kafkaConfigurationService.getKafkaServerPort();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerUrl + ":" + kafkaServerPort);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "K8S XMetrics Producer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());
		this.producer = new KafkaProducer<String, Object>(props);

		LOGGER.warn("Kafka producer initialized with properties: {}", props);
	}

	@Override
	public String send(final String topic, final Object data) {
		final String uuid = UUID.randomUUID().toString();
		final long startTime = System.currentTimeMillis();

		this.producer.send(new ProducerRecord<>(topic, uuid, data), new ProducerServiceCallback(startTime, uuid));

		return uuid;
	}

	@Override
	public void addListener(final String topic, final ProducerListener producerListener) {
		this.producerListenerMap.put(topic, producerListener);
	}


	class ProducerServiceCallback implements Callback {
		private final long startTime;
		private final String uuid;

		ProducerServiceCallback(final long startTime, final String uuid) {
			this.startTime = startTime;
			this.uuid = uuid;
		}

		@Override
		public void onCompletion(final RecordMetadata metadata, final Exception exception) {
			final long elapsedTime = System.currentTimeMillis() - this.startTime;
			final String topic = metadata.topic();
			final List<ProducerListener> producerListeners = ProducerServiceImpl.this.producerListenerMap.get(topic);
			for (final ProducerListener producerListener : producerListeners) {
				producerListener.onCompletion(topic, this.uuid, elapsedTime);
			}
		}
	}

	public void setKafkaConfigurationService(final KafkaConfigurationService kafkaConfigurationService) {
		this.kafkaConfigurationService = kafkaConfigurationService;
	}
}
