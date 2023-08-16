package predev07.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eip_m_post")
public class Post {
	@Id
	@Column(name = "post_id")
	private Long postId;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "post_name", nullable = false, length = 64)
	private String postName;

	@Column(name = "zipcode", length = 8)
	private String zipcode;

	@Column(name = "address", length = 64)
	private String address;

	@Column(name = "in_telephone", length = 15)
	private String inTelephone;

	@Column(name = "out_telephone", length = 15)
	private String outTelephone;

	@Column(name = "fax_number", length = 15)
	private String faxNumber;

	@OneToOne
	@JoinColumn(name = "group_name")
	private Group group;

	@Column(name = "sort")
	private int sort;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	public Post(Long postId, Company company, String postName, String zipcode, String address, String inTelephone,
			String outTelephone, String faxNumber, Group group, int sort, Date createDate, Date updateDate) {
		super();
		this.postId = postId;
		this.company = company;
		this.postName = postName;
		this.zipcode = zipcode;
		this.address = address;
		this.inTelephone = inTelephone;
		this.outTelephone = outTelephone;
		this.faxNumber = faxNumber;
		this.group = group;
		this.sort = sort;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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


}
