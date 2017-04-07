package com.foo.dao;

import java.util.List;

import com.foo.model.po.QrtzTrigger;

/**
 * <p>Description: </p>
 * @author JiaSonglin
 * @version V1.0,2017年1月5日 下午4:40:44
 */

public interface QrtzTriggerDao {

	String GET_ALL_TRIGGER = "SELECT * FROM QRTZ_TRIGGERS";
	
	public List<QrtzTrigger> getAll();
	
}
