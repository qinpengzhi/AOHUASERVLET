package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Pu_SupplierDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> getPu_Supplier(){
		String sql="select SupplierID,Name from pu_supplier";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
