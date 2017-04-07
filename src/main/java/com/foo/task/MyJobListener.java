package com.foo.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-19
 */
public class MyJobListener implements JobListener{

	private final Log log = LogFactory.getLog(getClass());
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myjob";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// TODO Auto-generated method stub
		log.info("myjob 任务开始执行！");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		// TODO Auto-generated method stub
		log.info("myjob 任务执行结束！");
	}

}
