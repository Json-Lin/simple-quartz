package com.foo.service.impl;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foo.service.JobService;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	Scheduler scheduler;
	
	@Override
	public JobDetail getJob(String name, String group) {
		
		return null;
	}
	
	@Override
	public JobDetail getJob(JobKey jobKey) {
		return null;
	}
	
	
}
