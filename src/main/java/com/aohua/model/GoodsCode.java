package com.aohua.model;

public class GoodsCode {
	private Integer GoodsID;//物料id
	private String GoodsCode;//物料编码
	private String GoodsName;//物料名称
	private String GoodsNotes;//物料描述
	private String Unit;//单位
	private String AdvancePeriod;//提前期
	private Integer PlanTimeFence;//计划时界
	private Integer ReqTimeFence;//需求时界
	private Integer GTID;//物料类别id
	private Integer OriginID;//来源
	private Integer IsBatchMgr;//是否批号管理
	private Integer MakeMethod;//加工方法
	private Integer DisableID;//停用标志
	public Integer getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(Integer goodsID) {
		GoodsID = goodsID;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		GoodsCode = goodsCode;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getGoodsNotes() {
		return GoodsNotes;
	}
	public void setGoodsNotes(String goodsNotes) {
		GoodsNotes = goodsNotes;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getAdvancePeriod() {
		return AdvancePeriod;
	}
	public void setAdvancePeriod(String advancePeriod) {
		AdvancePeriod = advancePeriod;
	}
	public Integer getPlanTimeFence() {
		return PlanTimeFence;
	}
	public void setPlanTimeFence(Integer planTimeFence) {
		PlanTimeFence = planTimeFence;
	}
	public Integer getReqTimeFence() {
		return ReqTimeFence;
	}
	public void setReqTimeFence(Integer reqTimeFence) {
		ReqTimeFence = reqTimeFence;
	}
	public Integer getGTID() {
		return GTID;
	}
	public void setGTID(Integer gTID) {
		GTID = gTID;
	}
	public Integer getOriginID() {
		return OriginID;
	}
	public void setOriginID(Integer originID) {
		OriginID = originID;
	}
	public Integer getIsBatchMgr() {
		return IsBatchMgr;
	}
	public void setIsBatchMgr(Integer isBatchMgr) {
		IsBatchMgr = isBatchMgr;
	}
	public Integer getMakeMethod() {
		return MakeMethod;
	}
	public void setMakeMethod(Integer makeMethod) {
		MakeMethod = makeMethod;
	}
	public Integer getDisableID() {
		return DisableID;
	}
	public void setDisableID(Integer disableID) {
		DisableID = disableID;
	}
}
