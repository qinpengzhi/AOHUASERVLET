package com.aohua.model;

//���۶���
public class Se_Order {	
	private Integer OrderID;
	private String OrderCode; //����
	private Integer CustID; //�ͻ�ID
	//��CustID��id��Ӧ��custName�������CustName���ǳ��Ա��ű�
	private String CustName; //�ͻ�
	private Integer ClauseID; //����ID
	private String ContractCode; //��ͬ��
	private Integer SellerID; //ҵ��ԱID
	//��ȡҵ��Աname
	private String SellerName;
	private Double SellerWDPrice; //γ����ɼ�
	private String SignAddr; //ǩ����ַ
	private String SignDate; //ǩ������
	private String DeliveryAddr; //������ַ
	private String DeliveryDate; //��������
	private Double Freight; //�������
	private Integer TransportID; //���䷽ʽ
	//��ȡ���䷽ʽ����
	private String TransportName;
	private Integer SettleID;//���㷽ʽ
	//��ȡ���㷽ʽname
	private String SettleName;
	private String ReceDate; //���տ���
	private Integer ReceDays;//���տ�����
	private Integer DeptID;   //
	//��ȡ��������
	private String DeptName;
	private Integer WritePersonID; //�Ƶ���ID
	private String WriteDate;   //�Ƶ�����
	private String Notes;
	private Integer State;
	private Integer ExeState;
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public Integer getCustID() {
		return CustID;
	}
	public void setCustID(Integer custID) {
		CustID = custID;
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
	public Integer getSellerID() {
		return SellerID;
	}
	public void setSellerID(Integer sellerID) {
		SellerID = sellerID;
	}
	public Double getSellerWDPrice() {
		return SellerWDPrice;
	}
	public void setSellerWDPrice(Double sellerWDPrice) {
		SellerWDPrice = sellerWDPrice;
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
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public Double getFreight() {
		return Freight;
	}
	public void setFreight(Double freight) {
		Freight = freight;
	}
	public Integer getTransportID() {
		return TransportID;
	}
	public void setTransportID(Integer transportID) {
		TransportID = transportID;
	}
	public Integer getSettleID() {
		return SettleID;
	}
	public void setSettleID(Integer settleID) {
		SettleID = settleID;
	}
	public String getReceDate() {
		return ReceDate;
	}
	public void setReceDate(String receDate) {
		ReceDate = receDate;
	}
	public Integer getReceDays() {
		return ReceDays;
	}
	public void setReceDays(Integer receDays) {
		ReceDays = receDays;
	}
	public Integer getDeptID() {
		return DeptID;
	}
	public void setDeptID(Integer deptID) {
		DeptID = deptID;
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
	public Integer getExeState() {
		return ExeState;
	}
	public void setExeState(Integer exeState) {
		ExeState = exeState;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getTransportName() {
		return TransportName;
	}
	public void setTransportName(String transportName) {
		TransportName = transportName;
	}
	public String getSettleName() {
		return SettleName;
	}
	public void setSettleName(String settleName) {
		SettleName = settleName;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getSellerName() {
		return SellerName;
	}
	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}
}
