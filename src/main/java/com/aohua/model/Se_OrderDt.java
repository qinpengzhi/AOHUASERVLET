package com.aohua.model;

public class Se_OrderDt {
	private Integer OrderDtID;
	private Integer OrderID;
	private Integer GoodsID;//����Id
	//��ѯ���ϱ�õ�������name
	private String GoodsName;
	private Double Number=null;//����
	private Double Price=null;//�۸�
	private Double Money=null;//���
	private String DtDeliveryDate;//��������
	private String DtNotes;//��ע
	private Double PKGNum=null;//��װ��
	private Integer CLothClassID;//����
	private Double RevSpeed;//���٣������ֶΣ�
	private Double MaterialPrive;//ԭ�ϵ��ۣ������ֶ�)
	private Double RealPrice;//ʵ�����쵥�ۣ������ֶΣ�
	private Double RatedPrice;//����쵥�ۣ������ֶΣ�
	private Double ExcessPrice;//����weimi���ۣ������ֶΣ�
	private Integer IsClassify;//�����־�������ֶΣ�
	private Integer CancelID;//��ɱ�־�������ֶΣ� 
	public Integer getOrderDtID() {
		return OrderDtID;
	}
	public void setOrderDtID(Integer orderDtID) {
		OrderDtID = orderDtID;
	}
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public Integer getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(Integer goodsID) {
		GoodsID = goodsID;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
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
	public String getDtDeliveryDate() {
		return DtDeliveryDate;
	}
	public void setDtDeliveryDate(String dtDeliveryDate) {
		DtDeliveryDate = dtDeliveryDate;
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
	public Integer getCLothClassID() {
		return CLothClassID;
	}
	public void setCLothClassID(Integer cLothClassID) {
		CLothClassID = cLothClassID;
	}
	public Double getRevSpeed() {
		return RevSpeed;
	}
	public void setRevSpeed(Double revSpeed) {
		RevSpeed = revSpeed;
	}
	public Double getMaterialPrive() {
		return MaterialPrive;
	}
	public void setMaterialPrive(Double materialPrive) {
		MaterialPrive = materialPrive;
	}
	public Double getRealPrice() {
		return RealPrice;
	}
	public void setRealPrice(Double realPrice) {
		RealPrice = realPrice;
	}
	public Double getRatedPrice() {
		return RatedPrice;
	}
	public void setRatedPrice(Double ratedPrice) {
		RatedPrice = ratedPrice;
	}
	public Double getExcessPrice() {
		return ExcessPrice;
	}
	public void setExcessPrice(Double excessPrice) {
		ExcessPrice = excessPrice;
	}
	public Integer getIsClassify() {
		return IsClassify;
	}
	public void setIsClassify(Integer isClassify) {
		IsClassify = isClassify;
	}
	public Integer getCancelID() {
		return CancelID;
	}
	public void setCancelID(Integer cancelID) {
		CancelID = cancelID;
	}
}
