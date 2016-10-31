package com.foo.service.impl;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;

import com.foo.service.SchedulerService;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public class SchedulerServiceImpl implements SchedulerService{

	@Autowired
	Scheduler scheduler;
	
	@Override
	public Scheduler getScheduler() throws SchedulerException{
		return this.scheduler;
	}
	
	public void scheduleJob(Trigger trigger) throws SchedulerException{
		scheduler.scheduleJob(trigger);
	}
}
