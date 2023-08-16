package com.tamvn.bt1.entities;

public class TurbineGroup {
    private int groupId;
    private String groupName;
    private byte[] objectData;
    private int ownerId;
    private String groupAliasName;
    private char publicFlag;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public byte[] getObjectData() {
		return objectData;
	}
	public void setObjectData(byte[] objectData) {
		this.objectData = objectData;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getGroupAliasName() {
		return groupAliasName;
	}
	public void setGroupAliasName(String groupAliasName) {
		this.groupAliasName = groupAliasName;
	}
	public char getPublicFlag() {
		return publicFlag;
	}
	public void setPublicFlag(char publicFlag) {
		this.publicFlag = publicFlag;
	}
    
    

    // constructors, getters, setters
}
