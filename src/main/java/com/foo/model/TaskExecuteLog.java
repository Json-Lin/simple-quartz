package com.foo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JiaSonglin
 * @version 1.0 2016-10-27
 */
@Entity
@Table
public class TaskExecuteLog implements Serializable{

	private static final long serialVersionUID = -8477973353146804068L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long operator;
	
	private String jobKey;
	
	private String message;
}
