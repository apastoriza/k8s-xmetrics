package com.k8s.xmetrics.scheduler;

import com.google.gson.reflect.TypeToken;
import com.k8s.xmetrics.model.k8s.Metadata;
import com.k8s.xmetrics.model.k8s.NodeMetrics;
import com.k8s.xmetrics.model.k8s.NodeMetricsList;
import com.k8s.xmetrics.model.k8s.NodeMetricsListItem;
import com.k8s.xmetrics.service.k8s.ApiCallService;
import com.k8s.xmetrics.service.kafka.ProducerService;
import io.kubernetes.client.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author apastoriza
 */
public class NodeMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeMonitorTask.class);
	private String linkNodes;

	private ApiCallService apiCallService;
	private ProducerService producerService;

	@Override
	public void run() {
		LOGGER.debug("Running nodes monitoring....");
		this.monitor();
	}

	private void monitor() {
		try {
			final NodeMetricsList nodeMetricsList = this.apiCallService.getData(this.linkNodes, new TypeToken<NodeMetricsList>() {
				//empty type token
			}.getType());
			assertThat(nodeMetricsList).isNotNull();
			final List<NodeMetricsListItem> items = nodeMetricsList.getItems();
			this.iterateNodes(items);
		} catch (final ApiException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void iterateNodes(final List<NodeMetricsListItem> items) {
		assertThat(items).isNotNull();
		for (final NodeMetricsListItem item : items) {
			try {
				final Metadata metadata = item.getMetadata();
				assertThat(items).isNotNull();
				final String selfLink = metadata.getSelfLink();
				final NodeMetrics nodeMetrics = this.apiCallService.getData(selfLink, new TypeToken<NodeMetrics>() {
					//empty type token
				}.getType());
				LOGGER.debug("Node Metrics '{}': {}", nodeMetrics.getMetadata().getName(), nodeMetrics);
				this.producerService.send("NodeMetrics", nodeMetrics);
			} catch (final ApiException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	public void setApiCallService(final ApiCallService apiCallService) {
		this.apiCallService = apiCallService;
	}

	public void setLinkNodes(final String linkNodes) {
		this.linkNodes = linkNodes;
	}

	public void setProducerService(final ProducerService producerService) {
		this.producerService = producerService;
	}
}
