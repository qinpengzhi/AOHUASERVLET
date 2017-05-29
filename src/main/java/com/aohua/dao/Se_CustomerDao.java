package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class Se_CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> getSe_Customer(){
		String sql="select CustID,CustName from se_customer";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
