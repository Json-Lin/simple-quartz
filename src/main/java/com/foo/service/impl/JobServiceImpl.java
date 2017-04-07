package com.foo.service.impl;

import static org.quartz.CronScheduleBuilder.cronSchedule;

import java.util.List;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foo.dao.QrtzTriggerDao;
import com.foo.job.JobRegistCenter;
import com.foo.model.po.QrtzTrigger;
import com.foo.model.vo.JobFormVo;
import com.foo.service.JobService;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private JobRegistCenter jobRegistCenter;
	
	@Autowired
	private QrtzTriggerDao qrtzTriggerDao;
	
	@Override
	public JobDetail getJob(String name, String group) {
		return this.getJob(new JobKey(name, group));
	}
	
	@Override
	public JobDetail getJob(JobKey jobKey) {
		return jobRegistCenter.getJob(jobKey);
	}

	@Override
	public Set<JobDetail> getAllJobs() {
		return jobRegistCenter.getAllJobs();
	}

	@Override
	public void schedule(JobFormVo jobFormVo) throws SchedulerException {
		JobDetail jobDetail = this.getJob(jobFormVo.getJobName(), jobFormVo.getJobGroup());
		Trigger trigger = null;
		switch (jobFormVo.getTriggerType()) {
		case CRON_TRIGGER:
			trigger = TriggerBuilder.newTrigger()
				.withIdentity(jobDetail.getKey().getName(),jobDetail.getKey().getGroup())
				.withSchedule(cronSchedule(jobFormVo.getExpression()))
				.build();
			break;
		case ONECE_TRIGGER:
			trigger = TriggerBuilder.newTrigger()
				.withIdentity(jobDetail.getKey().getName(),jobDetail.getKey().getGroup())
				.startNow()
				.build();
			break;
		case FIXED_TRIGGER:
			trigger = TriggerBuilder.newTrigger()
				.withIdentity(jobDetail.getKey().getName(),jobDetail.getKey().getGroup())
				.startAt(jobFormVo.getDate())
				.build();
			break;

		default:
			break;
		}
		scheduler.scheduleJob(jobDetail, trigger);
	}

	@Override
	public void pauseJob(JobKey jobKey) throws SchedulerException {
		scheduler.pauseJob(jobKey);
	}

	@Override
	public void resumeJob(JobKey jobKey) throws SchedulerException {
		scheduler.resumeJob(jobKey);
	}

	@Override
	public void remove(JobKey jobKey) throws SchedulerException {
		scheduler.deleteJob(jobKey);
	}

	@Override
	public Set<Trigger> getTriggers(Set<JobDetail> jobs) {
		return null;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<QrtzTrigger> getAllHasTriggerJobs() {
		List<QrtzTrigger> list = qrtzTriggerDao.getAll();
		return list;
	}
	
	
}
