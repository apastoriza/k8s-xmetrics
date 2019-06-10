package com.k8s.xmetrics.service.kafka;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author apastoriza
 */
public class KafkaJsonSerializer implements Serializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonSerializer.class);


	@Override
	public void configure(final Map configs, final boolean isKey) {
		//do nothing yet
	}

	@Override
	public byte[] serialize(final String topic, final Object data) {
		byte[] retVal = null;
		final ObjectMapper objectMapper = createObjectMapper();
		try {
			retVal = objectMapper.writeValueAsBytes(data);
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
		}
		return retVal;
	}

	@Override
	public void close() {
		//do nothing yet
	}

	private static ObjectMapper createObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}
