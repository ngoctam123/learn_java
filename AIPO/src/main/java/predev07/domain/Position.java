package predev07.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eip_m_position")
public class Position {
	@Id
	@Column(name = "position_id")
	private Long positionId;

	@Column(name = "position_name", nullable = false, length = 64)
	private String positionName;

	@Column(name = "sort")
	private int sort;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	@OneToMany(mappedBy = "position")
	private List<User> users;

	public Position(Long positionId, String positionName, int sort, Date createDate, Date updateDate, List<User> users) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.sort = sort;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.users = users;
	}

	public Position() {
		// TODO Auto-generated constructor stub
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



}
