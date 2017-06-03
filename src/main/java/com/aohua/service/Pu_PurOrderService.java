package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.Pu_PurOrderDao;
import com.aohua.model.Pu_PurOrder;
import com.aohua.model.Pu_PurOrderDt;

@Service
public class Pu_PurOrderService {
	@Autowired
	private Pu_PurOrderDao pu_PurOrderDao;
	public Long add(final Pu_PurOrder pu_PurOrder){
		return pu_PurOrderDao.add(pu_PurOrder);
	}
	public void addDt(final List<Pu_PurOrderDt> list){
		pu_PurOrderDao.addDt(list);
	}
	public List<Map<String,Object>> find(int WritePersonID){
		return pu_PurOrderDao.find(WritePersonID);
	}
	public List<Map<String,Object>> findbyid(int OrderID){
		return pu_PurOrderDao.findbyid(OrderID);
	}
	public List<Map<String,Object>> finddtbyid(int OrderID){
		return pu_PurOrderDao.finddtbyid(OrderID);
	}
}
