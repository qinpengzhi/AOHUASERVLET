package com.aohua.model;

public class Se_Customer {
	private Integer CustID;
	private String CustName;
	private String ShortName;//�ͻ����
	private Integer AreaID;//�ͻ�����id
	private String AreaName;//�ͻ�����name
	//��û��д�꣨���ݿ��ﻹ�кܶ��ֶΣ�
	public Integer getCustID() {
		return CustID;
	}
	public void setCustID(Integer custID) {
		CustID = custID;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getShortName() {
		return ShortName;
	}
	public void setShortName(String shortName) {
		ShortName = shortName;
	}
	public Integer getAreaID() {
		return AreaID;
	}
	public void setAreaID(Integer areaID) {
		AreaID = areaID;
	}
	public String getAreaName() {
		return AreaName;
	}
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}
}
