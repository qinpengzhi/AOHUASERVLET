package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.DepartMentDao;

@Service
public class DepartMentService {
	@Autowired
	private DepartMentDao departMentDao;
	public List<Map<String,Object>> getDepartMent(){
		return departMentDao.getDepartMent();
	}
}
