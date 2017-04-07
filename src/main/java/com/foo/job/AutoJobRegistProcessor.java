package com.foo.job;

import static org.quartz.JobBuilder.newJob;

import org.quartz.JobDetail;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jason
 * @date 2016-3-4
 * @version 1.0
 */
@Slf4j
@Component
public class AutoJobRegistProcessor implements BeanPostProcessor, Ordered {

	@Autowired
	private JobRegistCenter jobRegistCenter;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AbstractJob) {
			injectJob(bean, beanName);
		}
		return bean;
	}

	private void injectJob(Object bean, String beanName) {
		AbstractJob job = (AbstractJob) bean;
		JobDetail jobDetail = newJob(job.getClass())
				.withIdentity(job.getJobKey())
				.withDescription(job.getDescription())
				.build();
		jobRegistCenter.registJob(jobDetail);
		log.info(String.format("regist job --> [jobKey:%s].", jobDetail.getKey()));
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
