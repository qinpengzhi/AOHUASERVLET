package com.aohua.model;

public class Pu_PurOrderDt {
	private Integer PurOrderDtID;//采购订单明细ID
	private Integer PurOrderID;//采购订单ID
	private Integer PurPlanDtID;//采购计划明细ID
	private Integer GoodsID;//物料ID
	private Double Number;//数量
	private Double Price;//价格
	private Double Money;//金额
	private String DtAogDate;//明细到货日期
	private String DtNotes;//备注
	private Double PKGNum;//包装量
	public Integer getPurOrderDtID() {
		return PurOrderDtID;
	}
	public void setPurOrderDtID(Integer purOrderDtID) {
		PurOrderDtID = purOrderDtID;
	}
	public Integer getPurOrderID() {
		return PurOrderID;
	}
	public void setPurOrderID(Integer purOrderID) {
		PurOrderID = purOrderID;
	}
	public Integer getPurPlanDtID() {
		return PurPlanDtID;
	}
	public void setPurPlanDtID(Integer purPlanDtID) {
		PurPlanDtID = purPlanDtID;
	}
	public Integer getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(Integer goodsID) {
		GoodsID = goodsID;
	}
	public Double getNumber() {
		return Number;
	}
	public void setNumber(Double number) {
		Number = number;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Double getMoney() {
		return Money;
	}
	public void setMoney(Double money) {
		Money = money;
	}
	public String getDtAogDate() {
		return DtAogDate;
	}
	public void setDtAogDate(String dtAogDate) {
		DtAogDate = dtAogDate;
	}
	public String getDtNotes() {
		return DtNotes;
	}
	public void setDtNotes(String dtNotes) {
		DtNotes = dtNotes;
	}
	public Double getPKGNum() {
		return PKGNum;
	}
	public void setPKGNum(Double pKGNum) {
		PKGNum = pKGNum;
	}
}
