package com.foo.service;

import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-26
 */
public interface TaskService {

	void pauseTask(JobKey jobKey) throws SchedulerException;

	void pauseTask(TriggerKey triggerKey) throws SchedulerException;

	void resumeTask(JobKey jobKey) throws SchedulerException;

	void resumeTask(TriggerKey triggerKey) throws SchedulerException;

	void resumeAll() throws SchedulerException;

	void rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws SchedulerException;
}
