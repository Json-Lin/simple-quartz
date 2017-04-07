package com.foo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.foo.dao.QrtzTriggerDao;
import com.foo.model.po.QrtzTrigger;

/**
 * <p>Description: </p>
 * @author JiaSonglin
 * @version V1.0,2017年1月5日 下午4:40:44
 */

@Repository
public class QrtzTriggerDaoImpl implements QrtzTriggerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<QrtzTrigger> getAll(){
		List<QrtzTrigger> list = jdbcTemplate.query(GET_ALL_TRIGGER, new RowMapper<QrtzTrigger>(){

			@Override
			public QrtzTrigger mapRow(ResultSet rs, int rowNum) throws SQLException {
				QrtzTrigger qrtzTrigger = new QrtzTrigger();
				qrtzTrigger.setDescription(rs.getString("DESCRIPTION"));
				qrtzTrigger.setJobGroup(rs.getString("JOB_GROUP"));
				qrtzTrigger.setJobName(rs.getString("JOB_NAME"));
				qrtzTrigger.setNextFireTime(rs.getLong("NEXT_FIRE_TIME"));
				qrtzTrigger.setPrevFireTime(rs.getLong("PREV_FIRE_TIME"));
				qrtzTrigger.setSchedName(rs.getString("SCHED_NAME"));
				qrtzTrigger.setTriggerGroup(rs.getString("TRIGGER_GROUP"));
				qrtzTrigger.setTriggerName(rs.getString("TRIGGER_NAME"));
				qrtzTrigger.setTriggerState(rs.getString("TRIGGER_STATE"));
				qrtzTrigger.setTriggerType(rs.getString("TRIGGER_TYPE"));
				return qrtzTrigger;
			}
		});
		
		return list;
	}
	
}
