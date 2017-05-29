package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SettleModeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getSettleMode(){
		String sql="select SettleID,SettleName from settlemode";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
