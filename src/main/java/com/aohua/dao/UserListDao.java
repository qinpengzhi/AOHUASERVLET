package com.aohua.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserListDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getUserID(String name,String password){
		String sql="select UserID from userlist where UserName='"+name+"' And "
				+ "PSW='"+password+"'";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
//		if(list.size()!=0){
//			return (Integer) list.get(0).get("UserID");
//		}else{
//			return 0;
//		}
		try{
			int a=jdbcTemplate.queryForInt(sql);
			System.out.println(jdbcTemplate.queryForInt(sql));
		return jdbcTemplate.queryForInt(sql);
		}catch(Exception e){
			return 0;
		}
	}
}
