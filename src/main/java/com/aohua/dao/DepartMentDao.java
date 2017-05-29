package com.aohua.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartMentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getDepartMent(){
		String sql="select DeptID,DeptName from department";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
//		Map<Integer,String> returnMap=new HashMap<Integer, String>();
//		for(int i=0;i<list.size();i++){
//			returnMap.put((Integer)list.get(i).get("DeptID"), (String)list.get(i).get("DeptName"));
//		}
		return list;
	}
}
