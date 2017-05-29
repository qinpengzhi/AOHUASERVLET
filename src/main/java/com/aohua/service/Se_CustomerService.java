package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.Se_CustomerDao;

@Service
public class Se_CustomerService {
	@Autowired
	private Se_CustomerDao se_CustomerDao;
	
	public List<Map<String,Object>> getSe_Customer(){
		 return se_CustomerDao.getSe_Customer();
	}
	
}
