package com.aohua.model;

public class Pu_PurOrder {
	private Integer PurOrderID;//采购订单号
	private String PurOrderCode;//采购订单号
	private Integer PurPlanID;//采购计划id
	private Integer BuyerID;//采购员id
	private Integer SupplierID;//供应商ID
	private Integer ClauseID;//条款ID
	private String ContractCode;//合同号
	private Integer SettleID;//结算方式ID
	private Integer PayDays;//付款天数
	private String SignAddr;//签订地址
	private String SignDate;//签订日期
	private String DeliveryAddr;//到货地址
	private String AogDate;//到货日期
	private Integer WritePersonID;//制单人ID
	private String WriteDate;//制单日期
	private String Notes;//备注
	private Integer State;//状态
	private Integer CompleteState;//是否完成
	private Integer ProdOrderID;//生产订单ID(保留)
	private Integer IsBlankout;//是否作废
	public Integer getPurOrderID() {
		return PurOrderID;
	}
	public void setPurOrderID(Integer purOrderID) {
		PurOrderID = purOrderID;
	}
	public String getPurOrderCode() {
		return PurOrderCode;
	}
	public void setPurOrderCode(String purOrderCode) {
		PurOrderCode = purOrderCode;
	}
	public Integer getPurPlanID() {
		return PurPlanID;
	}
	public void setPurPlanID(Integer purPlanID) {
		PurPlanID = purPlanID;
	}
	public Integer getBuyerID() {
		return BuyerID;
	}
	public void setBuyerID(Integer buyerID) {
		BuyerID = buyerID;
	}
	public Integer getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(Integer supplierID) {
		SupplierID = supplierID;
	}
	public Integer getClauseID() {
		return ClauseID;
	}
	public void setClauseID(Integer clauseID) {
		ClauseID = clauseID;
	}
	public String getContractCode() {
		return ContractCode;
	}
	public void setContractCode(String contractCode) {
		ContractCode = contractCode;
	}
	public Integer getSettleID() {
		return SettleID;
	}
	public void setSettleID(Integer settleID) {
		SettleID = settleID;
	}
	public Integer getPayDays() {
		return PayDays;
	}
	public void setPayDays(Integer payDays) {
		PayDays = payDays;
	}
	public String getSignAddr() {
		return SignAddr;
	}
	public void setSignAddr(String signAddr) {
		SignAddr = signAddr;
	}
	public String getSignDate() {
		return SignDate;
	}
	public void setSignDate(String signDate) {
		SignDate = signDate;
	}
	public String getDeliveryAddr() {
		return DeliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		DeliveryAddr = deliveryAddr;
	}
	public String getAogDate() {
		return AogDate;
	}
	public void setAogDate(String aogDate) {
		AogDate = aogDate;
	}
	public Integer getWritePersonID() {
		return WritePersonID;
	}
	public void setWritePersonID(Integer writePersonID) {
		WritePersonID = writePersonID;
	}
	public String getWriteDate() {
		return WriteDate;
	}
	public void setWriteDate(String writeDate) {
		WriteDate = writeDate;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public Integer getState() {
		return State;
	}
	public void setState(Integer state) {
		State = state;
	}
	public Integer getCompleteState() {
		return CompleteState;
	}
	public void setCompleteState(Integer completeState) {
		CompleteState = completeState;
	}
	public Integer getProdOrderID() {
		return ProdOrderID;
	}
	public void setProdOrderID(Integer prodOrderID) {
		ProdOrderID = prodOrderID;
	}
	public Integer getIsBlankout() {
		return IsBlankout;
	}
	public void setIsBlankout(Integer isBlankout) {
		IsBlankout = isBlankout;
	}
}
