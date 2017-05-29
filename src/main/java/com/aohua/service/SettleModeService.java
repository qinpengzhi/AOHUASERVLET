package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.SettleModeDao;

@Service
public class SettleModeService {
	@Autowired
	private SettleModeDao settleModeDao;
	public List<Map<String,Object>> getSettleMode(){
		return settleModeDao.getSettleMode();
	}
}
