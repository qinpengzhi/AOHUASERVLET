package com.aohua.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aohua.model.Se_Order;

@Repository
public class Se_OrderDao {
	public void add(Se_Order se_Order){
		System.out.print("ADD se_order");
	}
	public void update(Se_Order se_Order){
		System.out.println("update se_order");
	}
	public void find(int WritePersonID){
		//每个用户能看到的订单列表
		//String sql="select * from "
	}
}
