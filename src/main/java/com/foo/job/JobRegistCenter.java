package com.foo.job;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

/**
 * <p>Description: 缓存所有现有的JobDetail</p>
 * @author JiaSonglin
 * @version V1.0,2017年1月5日 下午2:02:39
 */
@Component
public class JobRegistCenter {

	private static final ConcurrentHashMap<JobKey, JobDetail> JOB_CACHE = new ConcurrentHashMap<JobKey, JobDetail>();

	public void registJob(JobDetail job){
		if(!JOB_CACHE.containsKey(job.getKey())){
			JOB_CACHE.put(job.getKey(),job);
		}
	}
	
	public boolean isExists(JobKey jobKey){
		return JOB_CACHE.containsKey(jobKey);
	}
	
	public Set<JobDetail> getAllJobs(){
		Set<JobDetail> jobs = new HashSet<JobDetail>();
		for( Entry<JobKey, JobDetail> jobEntry:JOB_CACHE.entrySet()){
			jobs.add(jobEntry.getValue());
		}
		return jobs;
	}

	public JobDetail getJob(JobKey jobKey) {
		return JOB_CACHE.get(jobKey);
	}
}
