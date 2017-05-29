package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.DepartMentDao;
import com.aohua.dao.TransportModelDao;

@Service
public class TransportModelService {
	@Autowired
	private TransportModelDao transportModelDao;
	public List<Map<String,Object>> getTransportMode(){
		return transportModelDao.getTransportMode();
	}
}
