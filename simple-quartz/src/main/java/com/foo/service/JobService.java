package com.foo.service;

import org.quartz.JobDetail;
import org.quartz.JobKey;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public interface JobService {

	/**
	 * 
	 * @param name
	 * @param group
	 * @return
	 */
	JobDetail getJob(String name, String group);

	/**
	 * 
	 * @param jobKey
	 * @return
	 */
	JobDetail getJob(JobKey jobKey);

}
