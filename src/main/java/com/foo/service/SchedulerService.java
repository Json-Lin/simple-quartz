package com.foo.service;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public interface SchedulerService {

	Scheduler getScheduler() throws SchedulerException;

}
