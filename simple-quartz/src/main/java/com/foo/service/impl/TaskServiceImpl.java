package com.foo.service.impl;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.foo.service.TaskService;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-26
 */
public class TaskServiceImpl implements TaskService{

	
	@Autowired
	private Scheduler scheduler;
	
	@Override
	public void pauseTask(JobKey jobKey) throws SchedulerException{
		scheduler.pauseJob(jobKey);
	}
	
	@Override
	public void pauseTask(TriggerKey triggerKey) throws SchedulerException{
		scheduler.pauseTrigger(triggerKey);
	}
	
	@Override
	public void resumeTask(JobKey jobKey) throws SchedulerException{
		scheduler.resumeJob(jobKey);
	}
	
	@Override
	public void resumeTask(TriggerKey triggerKey) throws SchedulerException{
		scheduler.resumeTrigger(triggerKey);
	}
	
	@Override
	public void resumeAll() throws SchedulerException{
		scheduler.resumeAll();
	}
	
	@Override
	public void rescheduleJob(TriggerKey triggerKey,Trigger newTrigger) throws SchedulerException{
		scheduler.rescheduleJob(triggerKey, newTrigger);
	}
	
	

}
