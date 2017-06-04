package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.UserListDao;

@Service
public class UserListService {
	@Autowired
	private UserListDao userListDao;
	
	public List<Map<String,Object>>  getUserID(String name,String password){
		return userListDao.getUserID(name, password);
	}
	
}
