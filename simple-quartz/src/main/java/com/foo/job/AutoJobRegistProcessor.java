package com.foo.job;

import static org.quartz.JobBuilder.newJob;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author  jason
 * @date    2016-3-4
 * @version 1.0
 */
@Slf4j
@Component
public class AutoJobRegistProcessor implements BeanPostProcessor,Ordered{
	
	private Map<JobKey, JobDetail> jobCache = new HashMap<JobKey, JobDetail>();
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof AbstractJob){
			injectJob(bean,beanName);
		}
		return bean;
	}

	private void injectJob(Object bean, String beanName) {
		AbstractJob job = (AbstractJob) bean;
		Object obj = jobCache.get(beanName);
		if(null == obj){
			JobDetail jobDetail = newJob(job.getClass())
					.withIdentity(job.getJobKey())
					.withDescription(job.getDescription())
					.build();
			jobCache.put(job.getJobKey(), jobDetail);
			log.info(String.format("create job --> %s", jobDetail.getKey()));
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
	
	public Map<JobKey, JobDetail> getAllJob(){
		return jobCache;
	}

}
