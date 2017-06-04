package com.aohua.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.Se_OrderDao;
import com.aohua.model.Se_Order;
import com.aohua.model.Se_OrderDt;

@Service
public class Se_OrderService {
	@Autowired
	private Se_OrderDao se_orderDao;
	
	public Long add(Se_Order se_Order){
		return se_orderDao.add(se_Order);
	}
	public void addDt(final List<Se_OrderDt> list){
		se_orderDao.addDt(list);
	}
	public List<Map<String,Object>> findbyid(int OrderID){
		return se_orderDao.findbyid(OrderID);
	}
	public List<Map<String,Object>> finddtbyid(int OrderID){
		return se_orderDao.finddtbyid(OrderID);
	}
	public List<Map<String,Object>> find(int WritePersonID,int Examine){
		return se_orderDao.find(WritePersonID,Examine);
	}
	public void update(int OrderID,int State,String AuditOpinion){
		se_orderDao.update(OrderID, State, AuditOpinion);
	}
}
