package com.foo.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.foo.job.AbstractJob;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-20
 */
public class OneJob extends AbstractJob{
	
	private static final Log log = LogFactory.getLog(OneJob.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.info("runing...");
		System.out.println(1241);
	}

	@Override
	public String getJobName() {
		
		return "oneJob";
	}

	@Override
	public String getJobGroup() {
		return "";
	}

	@Override
	public String getDescription() {
		return "测试任务";
	}

}
