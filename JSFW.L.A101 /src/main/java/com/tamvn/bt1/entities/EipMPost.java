package com.tamvn.bt1.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EipMPost {
    private int postId;
    private int companyId;
    private String postName;
    private String zipcode;
    private String address;
    private String inTelephone;
    private String outTelephone;
    private String faxNumber;
    private String groupName;
    private int sort;
    private LocalDate createDate;
    private LocalDateTime updateDate;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInTelephone() {
		return inTelephone;
	}
	public void setInTelephone(String inTelephone) {
		this.inTelephone = inTelephone;
	}
	public String getOutTelephone() {
		return outTelephone;
	}
	public void setOutTelephone(String outTelephone) {
		this.outTelephone = outTelephone;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
    
    

    // constructors, getters, setters
}
