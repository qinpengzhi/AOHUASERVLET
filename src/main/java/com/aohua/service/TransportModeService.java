package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.TransportModeDao;

@Service
public class TransportModeService {
	@Autowired
	private TransportModeDao transportModelDao;
	public List<Map<String,Object>> getTransportMode(){
		return transportModelDao.getTransportMode();
	}
}
