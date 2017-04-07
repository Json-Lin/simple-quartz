package com.foo.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobKey;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
@DisallowConcurrentExecution
public abstract class AbstractJob implements Job{
	
	private static final String DEFAULT_GROUP = "DEFAULT";
	
	/**
	 * 设置job所在组
	 * @return
	 */
	public  String getJobGroup() {
		return this.getClass().getName();
	}
	
	/**
	 * 设置job描述
	 * @return
	 */
	public  String getDescription() {
		return "";
	}

	
	/**
	 * 设置job描述
	 * @return
	 */
	public  String getJobName() {
		return DEFAULT_GROUP;
	}
	
	/**
	 * 设置jobKey
	 * name & group 确定唯一的jobKey
	 * @return
	 */
	public JobKey getJobKey(){
		return new JobKey(getJobName(), getJobGroup());
	}
}
