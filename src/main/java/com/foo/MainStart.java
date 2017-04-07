package com.foo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author JiaSonglin
 * @version 1.0 2016-7-27
 */
@SpringBootApplication
public class MainStart {
	
	private static final Log log = LogFactory.getLog(MainStart.class);
	
	@Bean
	public Scheduler getScheduler() {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
			scheduler.start();
			log.info("===>>>start scheduler <<<===");
		} catch (SchedulerException e) {
			log.info("===>>>start scheduler error!<<<===",e);
		}
		return scheduler;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainStart.class, args);
	}
}