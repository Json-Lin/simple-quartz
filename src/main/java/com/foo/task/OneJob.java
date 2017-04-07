package com.foo.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.foo.job.AbstractJob;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
@Component("oneJob")
public class OneJob extends AbstractJob{
	
	private static final Log log = LogFactory.getLog(OneJob.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		try {
			log.info(jobDetail.getKey()+" "+Thread.currentThread().getName()+" is runing...");
			
			while(true){
				System.out.println("job is runing..");
				Thread.sleep(1000*2);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getJobName() {
		
		return "oneJob";
	}

	@Override
	public String getJobGroup() {
		return "group1";
	}

	@Override
	public String getDescription() {
		return "测试任务";
	}

}
