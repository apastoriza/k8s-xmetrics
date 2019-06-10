package com.k8s.xmetrics.service.kafka;

/**
 * @author apastoriza
 */
public interface ProducerService {
	String send(String topic, Object data);

	void addListener(String topic, ProducerListener producerListener);
}
