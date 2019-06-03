package com.k8s.xmetrics.test.agent.boot;

import com.k8s.xmetrics.agent.boot.Application;
import com.k8s.xmetrics.scheduler.NodeMonitorTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author apastoriza
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NodeMonitorTaskTestIT {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeMonitorTaskTestIT.class);

	@Autowired
	private ApplicationContext context;

	/*
	 * This test proves that the application can be loaded successful and that
	 * all @configurations and dependencies are there
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(this.context.getBean("monitorTask")).isNotNull();
		final NodeMonitorTask nodeMonitorTask = (NodeMonitorTask) this.context.getBean("monitorTask");
		//nodeMonitorTask.forceMonitor();
	}

}
