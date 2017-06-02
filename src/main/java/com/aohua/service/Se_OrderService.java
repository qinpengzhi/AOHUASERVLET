package com.aohua.service;


import java.util.List;

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
	public void update(Se_Order se_Order){
		se_orderDao.update(se_Order);
	}
}
