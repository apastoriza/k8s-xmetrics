package com.k8s.xmetrics.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collection;
import java.util.Properties;

/**
 * @author apastoriza
 */
class ConsumerServiceRunnable implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceRunnable.class);

	private final Properties props;
	private final Collection<String> topics;
	private boolean stopExecution;

	ConsumerServiceRunnable(final Properties props, final Collection<String> topics) {
		this.props = props;
		this.topics = topics;
		this.stopExecution = false;
	}

	@Override
	public void run() {
		try (final KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(this.props)) {
			consumer.subscribe(this.topics);
			while (!this.stopExecution) {
				final ConsumerRecords<String, Object> records = consumer.poll(Duration.ofSeconds(1));

				for (final ConsumerRecord<String, Object> record : records) {
					LOGGER.warn("partition = {}, offset = {}, key = {}, value = {}", record.partition(), record.offset(), record.key(), record.value());
				}

			}
		}
	}

	public void setStopExecution(final boolean stopExecution) {
		this.stopExecution = stopExecution;
	}
}
