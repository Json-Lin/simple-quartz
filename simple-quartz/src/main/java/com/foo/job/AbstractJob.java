package com.foo.job;

import org.quartz.Job;
import org.quartz.JobKey;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public abstract class AbstractJob implements Job{
	
	
	/**
	 * 设置job所在组
	 * @return
	 */
	public abstract String getJobGroup();
	
	/**
	 * 设置job描述
	 * @return
	 */
	public abstract String getDescription();

	
	/**
	 * 设置job描述
	 * @return
	 */
	public abstract String getJobName();
	
	/**
	 * 设置jobKey
	 * name & group 确定唯一的jobKey
	 * @return
	 */
	public JobKey getJobKey(){
		return new JobKey(getJobName(), getJobGroup());
	}
}
