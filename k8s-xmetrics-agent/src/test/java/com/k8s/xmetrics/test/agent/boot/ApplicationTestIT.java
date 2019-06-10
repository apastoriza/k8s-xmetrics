package com.k8s.xmetrics.test.agent.boot;

import com.k8s.xmetrics.agent.boot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ApplicationTestIT {
	@Autowired
	private ApplicationContext context;

	/*
	 * This test proves that the application can be loaded successful and that
	 * all @configurations and dependencies are there
	 */
	@Test
	public void contextLoads() {
		assertThat(this.context).isNotNull();
		assertThat(this.context.getApplicationName()).isNotNull();
		assertThat(this.context.getId()).isNotNull();
	}

}
