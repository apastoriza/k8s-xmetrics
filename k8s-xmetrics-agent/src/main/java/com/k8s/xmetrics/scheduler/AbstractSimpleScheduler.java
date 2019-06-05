package com.k8s.xmetrics.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author apastoriza
 */
abstract class AbstractSimpleScheduler {
	private TaskScheduler taskScheduler;
	private Runnable monitorTask;
	private String cronExpression;

	public void initMethod() {
		final Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.debug("Initializing Monitor Scheduler");
		final Trigger trigger = new CronTrigger(this.cronExpression);
		this.taskScheduler.schedule(this.monitorTask, trigger);
	}

	public void setTaskScheduler(final TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
	}

	public void setMonitorTask(final Runnable monitorTask) {
		this.monitorTask = monitorTask;
	}

	public void setCronExpression(final String cronExpression) {
		this.cronExpression = cronExpression;
	}
}
