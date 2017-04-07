package com.foo.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.foo.enums.TriggerType;

/**
 * <p>Description: 添加trigger时,绑定的模型</p>
 * @author JiaSonglin
 * @version V1.0,2017年1月5日 下午3:18:15
 */
public class JobFormVo implements Serializable{
	
	private static final long serialVersionUID = 696067916324384956L;

	private TriggerType triggerType;
	
	private String expression;
	
	private String jobName;
	
	private String jobGroup;
	
	private Date date;
	
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

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public TriggerType getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(TriggerType triggerType) {
		this.triggerType = triggerType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
