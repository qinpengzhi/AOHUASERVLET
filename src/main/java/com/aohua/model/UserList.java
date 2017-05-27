package com.aohua.model;

public class UserList {
	private Integer UserID;
	private Integer EmplID;
	private String UserName;
	private String PSW;
	private Integer GroupID;
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getEmplID() {
		return EmplID;
	}
	public void setEmplID(Integer emplID) {
		EmplID = emplID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPSW() {
		return PSW;
	}
	public void setPSW(String pSW) {
		PSW = pSW;
	}
	public Integer getGroupID() {
		return GroupID;
	}
	public void setGroupID(Integer groupID) {
		GroupID = groupID;
	}
}
