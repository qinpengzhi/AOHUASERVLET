package com.aohua.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohua.dao.Pu_SupplierDao;

@Service
public class Pu_SupplierService {
	@Autowired
	private Pu_SupplierDao pu_SupplierDao;
	public List<Map<String,Object>> getPu_Supplier(){
		return pu_SupplierDao.getPu_Supplier();
	}
}
