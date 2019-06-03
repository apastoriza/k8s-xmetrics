package com.k8s.xmetrics.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author apastoriza
 */
public class ObjectMapperFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectMapperFactory.class);

	public static ObjectMapper create(){
		final ObjectMapper mapper= new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}
