package com.aohua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.UserListDao;

@Service
public class UserListService {
	@Autowired
	private UserListDao userListDao;
	
	public int getUserID(String name,String password){
		return userListDao.getUserID(name, password);
	}
	
}
