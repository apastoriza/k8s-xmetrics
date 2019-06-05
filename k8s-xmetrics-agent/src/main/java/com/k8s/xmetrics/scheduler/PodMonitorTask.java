package com.k8s.xmetrics.scheduler;

import com.google.gson.reflect.TypeToken;
import com.k8s.xmetrics.model.k8s.Metadata;
import com.k8s.xmetrics.model.k8s.PodMetrics;
import com.k8s.xmetrics.model.k8s.PodMetricsList;
import com.k8s.xmetrics.model.k8s.PodMetricsListItem;
import com.k8s.xmetrics.service.k8s.ApiCallService;
import io.kubernetes.client.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author apastoriza
 */
public class PodMonitorTask implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(PodMonitorTask.class);

	private String linkPods;

	private ApiCallService apiCallService;

	@Override
	public void run() {
		LOGGER.warn("Running node update....");
		this.monitor();
	}

	private void monitor() {
		try {
			final PodMetricsList podMetricsList = this.apiCallService.getData(this.linkPods, new TypeToken<PodMetricsList>() {
				//empty type token
			}.getType());
			assertThat(podMetricsList).isNotNull();
			final List<PodMetricsListItem> items = podMetricsList.getItems();
			this.iteratePods(items);
		} catch (final ApiException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void iteratePods(final List<PodMetricsListItem> items) {
		assertThat(items).isNotNull();
		for (final PodMetricsListItem item : items) {
			try {
				final Metadata metadata = item.getMetadata();
				assertThat(items).isNotNull();
				final String selfLink = metadata.getSelfLink();
				final PodMetrics podMetrics = this.apiCallService.getData(selfLink, new TypeToken<PodMetrics>() {
					//empty type token
				}.getType());
				LOGGER.warn("Pod Metrics '{}': {}", podMetrics.getMetadata().getName(), podMetrics);
			} catch (final ApiException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	public void setApiCallService(final ApiCallService apiCallService) {
		this.apiCallService = apiCallService;
	}

	public void setLinkPods(final String linkPods) {
		this.linkPods = linkPods;
	}

}
