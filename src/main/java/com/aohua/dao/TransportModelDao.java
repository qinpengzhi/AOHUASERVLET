package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransportModelDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getTransportMode(){
		String sql="select TransportID,TransportName from transportmode";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
