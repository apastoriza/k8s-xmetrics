package com.k8s.xmetrics.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k8s.xmetrics.vo.hardware.CPUInfoVO;
import com.k8s.xmetrics.vo.hardware.ComputerInfoVO;
import com.k8s.xmetrics.vo.hardware.MemoryInfoVO;
import com.k8s.xmetrics.vo.hardware.NetworkInfoVO;
import com.k8s.xmetrics.vo.k8s.NodeMetricsVO;
import com.k8s.xmetrics.vo.k8s.PodMetricsVO;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author apastoriza
 */
public class KafkaJsonDeserializer implements Deserializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonDeserializer.class);

	public KafkaJsonDeserializer() {
		//do nothing yet
	}

	@Override
	public void configure(final Map configs, final boolean isKey) {
		//do nothing yet
	}

	@Override
	public Object deserialize(final String topic, final byte[] data) {
		final ObjectMapper mapper = new ObjectMapper();
		Object obj = null;
		try {
			switch (topic) {
				case "MemoryInfo":
					obj = mapper.readValue(data, MemoryInfoVO.class);
					break;
				case "NetworkInfo":
					obj = mapper.readValue(data, NetworkInfoVO.class);
					break;
				case "ComputerInfo":
					obj = mapper.readValue(data, ComputerInfoVO.class);
					break;
				case "CPUInfo":
					obj = mapper.readValue(data, CPUInfoVO.class);
					break;
				case "NodeMetrics":
					obj = mapper.readValue(data, NodeMetricsVO.class);
					break;
				case "PodMetrics":
					obj = mapper.readValue(data, PodMetricsVO.class);
					break;
				default:
					obj = mapper.readValue(data, String.class);
					break;
			}

		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
		}
		return obj;
	}

	@Override
	public void close() {
		//do nothing yet
	}
}
