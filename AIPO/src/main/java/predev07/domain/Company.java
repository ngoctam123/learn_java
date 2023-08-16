package predev07.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eip_m_company")
public class Company {
	@Id
	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "company_name", nullable = false, length = 64)
	private String companyName;

	@Column(name = "company_name_kana", length = 64)
	private String companyNameKana;

	@Column(name = "zipcode", length = 8)
	private String zipcode;

	@Column(name = "address", length = 64)
	private String address;

	@Column(name = "telephone", length = 15)
	private String telephone;

	@Column(name = "fax_number", length = 15)
	private String faxNumber;

	@Column(name = "url", length = 99)
	private String url;

	@Column(name = "ipaddress", length = 99)
	private String ipAddress;

	@Column(name = "port")
	private Integer port;

	@Column(name = "ipaddress_internal", length = 99)
	private String ipAddressInternal;

	@Column(name = "port_internal")
	private Integer portInternal;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	@OneToMany(mappedBy = "company")
	private List<User> users;

	@OneToMany(mappedBy = "company" , fetch = FetchType.EAGER)
	private List<Post> posts;

	public Company(Long companyId, String companyName, String companyNameKana, String zipcode, String address,
			String telephone, String faxNumber, String url, String ipAddress, Integer port, String ipAddressInternal,
			Integer portInternal, Date createDate, Date updateDate, List<User> users, List<Post> posts) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyNameKana = companyNameKana;
		this.zipcode = zipcode;
		this.address = address;
		this.telephone = telephone;
		this.faxNumber = faxNumber;
		this.url = url;
		this.ipAddress = ipAddress;
		this.port = port;
		this.ipAddressInternal = ipAddressInternal;
		this.portInternal = portInternal;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.users = users;
		this.posts = posts;
	}

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
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

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getIpAddressInternal() {
		return ipAddressInternal;
	}

	public void setIpAddressInternal(String ipAddressInternal) {
		this.ipAddressInternal = ipAddressInternal;
	}

	public Integer getPortInternal() {
		return portInternal;
	}

	public void setPortInternal(Integer portInternal) {
		this.portInternal = portInternal;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
