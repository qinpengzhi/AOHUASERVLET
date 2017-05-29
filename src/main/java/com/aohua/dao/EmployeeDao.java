package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> getEmployee(){
		String sql="select EmpID,EmpName from employee";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
