package com.k8s.xmetrics.service.kafka;

/**
 * @author apastoriza
 */
public interface ProducerListener {
	void onCompletion(String topic, String uuid, long elapsedTime);
}
