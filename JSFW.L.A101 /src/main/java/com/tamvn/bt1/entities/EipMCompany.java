package com.tamvn.bt1.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EipMCompany {
    private int companyId;
    private String companyName;
    private String companyNameKana;
    private String zipcode;
    private String address;
    private String telephone;
    private String faxNumber;
    private String url;
    private String ipAddress;
    private int port;
    private String ipAddressInternal;
    private int portInternal;
    private LocalDate createDate;
    private LocalDateTime updateDate;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNameKana() {
		return companyNameKana;
	}
	public void setCompanyNameKana(String companyNameKana) {
		this.companyNameKana = companyNameKana;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIpAddressInternal() {
		return ipAddressInternal;
	}
	public void setIpAddressInternal(String ipAddressInternal) {
		this.ipAddressInternal = ipAddressInternal;
	}
	public int getPortInternal() {
		return portInternal;
	}
	public void setPortInternal(int portInternal) {
		this.portInternal = portInternal;
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
