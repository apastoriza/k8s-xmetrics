package com.k8s.xmetrics.backend.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author apastoriza
 */
@Configuration
@ComponentScan(basePackages = {"com.k8s.xmetrics"})
@ImportResource("classpath*:META-INF/spring/k8s-xmetrics-*.xml")
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
