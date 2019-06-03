package com.k8s.xmetrics.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k8s.xmetrics.model.k8s.NodeMetricsList;
import com.k8s.xmetrics.service.RestTemplateService;
import com.k8s.xmetrics.util.ObjectMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author apastoriza
 */
public class NodeMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeMonitorTask.class);

	private final ObjectMapper mapper;
	private RestTemplateService restTemplateService;
	private String host;
	private String link;

	public NodeMonitorTask(){
		this.mapper = ObjectMapperFactory.create();
	}

	@Override
	public void run() {
		LOGGER.warn("Running node update....");
		this.monitor();
	}

	public void forceMonitor(){
		this.monitor();
	}

	private void monitor() {
		final String url = this.host.concat("/").concat(this.link);
		try {
			final String jsonNodeMetricsList = this.restTemplateService.getJson(url);
			final NodeMetricsList nodeMetricsList = this.mapper.readValue(jsonNodeMetricsList, NodeMetricsList.class);
			LOGGER.warn("nodeMetricsList: {}", nodeMetricsList);
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void setRestTemplateService(final RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public void setLink(final String link) {
		this.link = link;
	}
}
