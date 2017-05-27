package com.aohua.model;

public class DepartMent {
	private Integer DeptID;
	private String DeptCode;
	private String DeptName;
	private Integer ParentID;
	private Integer IsParent;
	public Integer getDeptID() {
		return DeptID;
	}
	public void setDeptID(Integer deptID) {
		DeptID = deptID;
	}
	public String getDeptCode() {
		return DeptCode;
	}
	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public Integer getParentID() {
		return ParentID;
	}
	public void setParentID(Integer parentID) {
		ParentID = parentID;
	}
	public Integer getIsParent() {
		return IsParent;
	}
	public void setIsParent(Integer isParent) {
		IsParent = isParent;
	}
	
}
