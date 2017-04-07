package com.foo.controller;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Hibernate;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foo.model.ControllerMessage;
import com.foo.model.po.QrtzTrigger;
import com.foo.model.vo.JobFormVo;
import com.foo.service.JobService;
import com.foo.task.OneJob;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author JiaSonglin
 * @version V1.0,2017年1月3日 下午4:32:49
 */
@Controller
public class JobController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private Scheduler scheduler;
	
	@RequestMapping("/")
	public ModelAndView index() throws SchedulerException {
		ModelAndView mav = new ModelAndView("/index");
		List<QrtzTrigger> triggers = jobService.getAllHasTriggerJobs();
		for (QrtzTrigger trg : triggers) {
			long prevFt = trg.getPrevFireTime();
			long nextFt = trg.getNextFireTime();
			Date lastRt = new Date(prevFt);
			Date nextRt = new Date(nextFt);
			trg.setLastRunTime(lastRt);
			trg.setNextRunTime(nextRt);
		}
		Set<JobDetail> set = jobService.getAllJobs();
		List<JobDetail> list = new ArrayList<JobDetail>(set);
		mav.addObject("jobs", list);
		mav.addObject("triggers", triggers);
		return mav;
	}
	
	
	
	@RequestMapping("/addFast")
	public Object add(String name,String work) {
		ControllerMessage msg = new ControllerMessage();
		try {
			JobDetail jobDetail = newJob(OneJob.class).withIdentity("job-"+name, "group-"+name).build();
			CronTrigger tirgger = TriggerBuilder.newTrigger()
					.withIdentity("job-"+name,"group-"+name)
					.withSchedule(cronSchedule("0/15 * * * * ?"))
					.build();
			scheduler.scheduleJob(jobDetail, tirgger);
			msg.setSucceeded(true);
			System.out.println("add job successed!");
		} catch (Exception e) {
			msg.setSucceeded(false);
			msg.setMessage("添加任务失败:" + e.getMessage());
			System.out.println(e.getMessage()+e);
		}
		return msg;
	}
	

	@RequestMapping("/add")
	public Object addTrigger(JobFormVo jobFormVo) {
		ControllerMessage msg = new ControllerMessage();
		try {
			jobService.schedule(jobFormVo);
			msg.setSucceeded(true);
		} catch (Exception e) {
			msg.setSucceeded(false);
			msg.setMessage("添加任务失败:" + e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/pause")
	public Object pause(JobFormVo jobFormVo) {
		JobKey jobKey = new JobKey(jobFormVo.getJobName(), jobFormVo.getJobGroup());
		ControllerMessage msg = new ControllerMessage();
		try {
			jobService.pauseJob(jobKey);
			msg.setSucceeded(true);
		} catch (SchedulerException e) {
			msg.setSucceeded(false);
			msg.setMessage("暂停任务失败:" + e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping("/interrupt")
	public Object interrupt(String work) {
		ControllerMessage msg = new ControllerMessage();
		try {
//			this.remove(jobFormVo);
			Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
			for(Entry<Thread, StackTraceElement[]> thread:threads.entrySet()){
				Thread t = thread.getKey();
				if(t.getName().equals("MyScheduler_Worker-"+work)){
					t.interrupt();
				}
			}
		} catch (Exception e) {
			msg.setSucceeded(false);
			msg.setMessage("暂停任务失败:" + e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/resume")
	public Object resume(JobFormVo jobFormVo) {
		JobKey jobKey = new JobKey(jobFormVo.getJobName(), jobFormVo.getJobGroup());
		ControllerMessage msg = new ControllerMessage();
		try {
			jobService.resumeJob(jobKey);
			msg.setSucceeded(true);
		} catch (SchedulerException e) {
			msg.setSucceeded(false);
			msg.setMessage("恢复任务失败:" + e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/remove")
	public Object remove(JobFormVo jobFormVo) {
		JobKey jobKey = new JobKey(jobFormVo.getJobName(), jobFormVo.getJobGroup());
		ControllerMessage msg = new ControllerMessage();
		try {
			jobService.remove(jobKey);
			msg.setSucceeded(true);
		} catch (SchedulerException e) {
			msg.setSucceeded(false);
			msg.setMessage("移除任务失败:" + e.getMessage());
		}
		return msg;
	}
}
