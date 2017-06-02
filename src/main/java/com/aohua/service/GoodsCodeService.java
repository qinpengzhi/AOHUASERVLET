package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.GoodsCodeDao;

@Service
public class GoodsCodeService {
	@Autowired
	private GoodsCodeDao goodsCodeDao;
	public List<Map<String,Object>> getGoodsCode(){
		return goodsCodeDao.getGoodsCode();
	}
}
