package com.foo.service;

import java.util.List;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.foo.model.po.QrtzTrigger;
import com.foo.model.vo.JobFormVo;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public interface JobService {

	/**
	 * get job
	 * @param name
	 * @param group
	 * @return
	 */
	JobDetail getJob(String name, String group);

	/**
	 * get job
	 * @param jobKey
	 * @return
	 */
	JobDetail getJob(JobKey jobKey);
	
	/**
	 * get all job
	 * @return
	 */
	Set<JobDetail> getAllJobs();

	/**
	 * @param triggerVo
	 * @throws SchedulerException 
	 */
	void schedule(JobFormVo triggerVo) throws SchedulerException;

	/**
	 * @param jobKey
	 * @throws SchedulerException 
	 */
	void pauseJob(JobKey jobKey) throws SchedulerException;

	/**
	 * @param jobKey
	 * @throws SchedulerException 
	 */
	void resumeJob(JobKey jobKey) throws SchedulerException;

	/**
	 * @param jobKey
	 * @throws SchedulerException 
	 */
	void remove(JobKey jobKey) throws SchedulerException;

	/**
	 * @param jobs
	 * @return
	 */
	Set<Trigger> getTriggers(Set<JobDetail> jobs);

	/**
	 * @return
	 */
	List<QrtzTrigger> getAllHasTriggerJobs();

}
