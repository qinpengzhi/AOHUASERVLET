package com.aohua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aohua.dao.Se_OrderDao;
import com.aohua.model.Se_Order;

@Component
//应该为@Service只是还没有连接数据库
public class Se_OrderService {
	@Autowired
	private Se_OrderDao se_orderDao;
	
	public void add(Se_Order se_Order){
		se_orderDao.add(se_Order);
	}
	public void update(Se_Order se_Order){
		se_orderDao.update(se_Order);
	}
}
