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
	
	public List<Map<String,Object>> getUserID(String name,String password){
		String sql="select u.UserID,p.Examine from userlist u left join power p on u.GroupID=p.UserGroupID where UserName='"+name+"' And "
				+ "PSW='"+password+"'";
		return jdbcTemplate.queryForList(sql);
//		
//		try{
//			int a=jdbcTemplate.queryForInt(sql);
//			System.out.println(jdbcTemplate.queryForInt(sql));
//		return jdbcTemplate.queryForInt(sql);
//		}catch(Exception e){
//			return 0;
//		}
	}
}
