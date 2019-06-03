package com.k8s.xmetrics.agent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author apastoriza
 */
@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/services")
	public List<String> services() {
		LOGGER.error("Getting all services....");
		return this.discoveryClient.getServices();
	}

}
