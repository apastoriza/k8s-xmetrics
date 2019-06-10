package com.k8s.xmetrics.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author apastoriza
 */
@Service(value = "environmentConfigurationService")
public class EnvironmentConfigurationServiceImpl implements EnvironmentConfigurationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentConfigurationServiceImpl.class);
}
