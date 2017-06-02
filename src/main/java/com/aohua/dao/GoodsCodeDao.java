package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsCodeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> getGoodsCode(){
		String sql="select GoodsID,GoodsName,Unit from goodscode";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
