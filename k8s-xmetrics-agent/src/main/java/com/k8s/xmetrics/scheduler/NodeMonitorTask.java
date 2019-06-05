package com.k8s.xmetrics.scheduler;

import com.google.gson.reflect.TypeToken;
import com.k8s.xmetrics.model.k8s.Metadata;
import com.k8s.xmetrics.model.k8s.NodeMetrics;
import com.k8s.xmetrics.model.k8s.NodeMetricsList;
import com.k8s.xmetrics.model.k8s.NodeMetricsListItem;
import com.k8s.xmetrics.model.k8s.PodMetricsList;
import com.k8s.xmetrics.service.k8s.ApiCallService;
import io.kubernetes.client.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author apastoriza
 */
public class NodeMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeMonitorTask.class);
	private String linkNodes;
	private String linkPods;

	private ApiCallService apiCallService;

	public NodeMonitorTask() {

	}

	@Override
	public void run() {
		LOGGER.warn("Running node update....");
		this.monitor();
	}

	private void monitor() {
		this.monitorNodes();
		this.monitorPods();
	}

	private void monitorNodes() {
		try {
			final NodeMetricsList nodeMetricsList = this.apiCallService.getData(this.linkNodes, new TypeToken<NodeMetricsList>() {
			}.getType());
			LOGGER.warn("Nodes as nodeMetricsList = {}", nodeMetricsList);

			final List<NodeMetricsListItem> items = nodeMetricsList.getItems();
			for (final NodeMetricsListItem item : items) {
				final Metadata metadata = item.getMetadata();
				if (metadata != null) {
					final String selfLink = metadata.getSelfLink();
					final NodeMetrics nodeMetrics = this.apiCallService.getData(selfLink, new TypeToken<NodeMetrics>() {
					}.getType());
					LOGGER.warn("'{}' nodeMetrics = {}", nodeMetrics.getMetadata().getName(), nodeMetrics);
				}
			}
		} catch (final ApiException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void monitorPods() {
		try {
			final PodMetricsList podMetricsList = this.apiCallService.getData(this.linkPods, new TypeToken<PodMetricsList>() {
			}.getType());
			LOGGER.warn("Pods as podMetricsList = {}", podMetricsList);

		} catch (final ApiException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void setApiCallService(final ApiCallService apiCallService) {
		this.apiCallService = apiCallService;
	}

	public void setLinkNodes(final String linkNodes) {
		this.linkNodes = linkNodes;
	}

	public void setLinkPods(final String linkPods) {
		this.linkPods = linkPods;
	}
}
