package com.aohua.model;

public class Pu_PurOrderDt {
	private Integer PurOrderDtID;//�ɹ�������ϸID
	private Integer PurOrderID;//�ɹ�����ID
	private Integer PurPlanDtID;//�ɹ��ƻ���ϸID
	private Integer GoodsID;//����ID
	private Double Number;//����
	private Double Price;//�۸�
	private Double Money;//���
	private String DtAogDate;//��ϸ��������
	private String DtNotes;//��ע
	private Double PKGNum;//��װ��
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
