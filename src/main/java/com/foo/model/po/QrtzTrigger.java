package com.foo.model.po;

import java.util.Date;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author JiaSonglin
 * @version V1.0,2017年1月5日 下午4:21:25
 */
public class QrtzTrigger {
	private String schedName;
	private String triggerName;
	private String triggerGroup;
	private String jobName;
	private String jobGroup;
	private String description;
	private Long prevFireTime;
	private Long nextFireTime;
	private String triggerType;
	private String triggerState;
	private Date lastRunTime;
	private Date nextRunTime;

	public Date getLastRunTime() {
		return lastRunTime;
	}

	public void setLastRunTime(Date lastRunTime) {
		this.lastRunTime = lastRunTime;
	}

	public Date getNextRunTime() {
		return nextRunTime;
	}

	public void setNextRunTime(Date nextRunTime) {
		this.nextRunTime = nextRunTime;
	}

	public String getSchedName() {
		return schedName;
	}

	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrevFireTime() {
		return prevFireTime;
	}

	public void setPrevFireTime(Long prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	public Long getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(Long nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getTriggerState() {
		return triggerState;
	}

	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

}
