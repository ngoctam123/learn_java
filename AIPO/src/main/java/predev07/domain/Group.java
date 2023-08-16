package predev07.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turbine_group")
public class Group {
    @Id
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name", nullable = false, length = 99)
    private String groupName;

    @Lob
    @Column(name = "objectdata")
    private byte[] objectData;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "group_alias_name")
    private String groupAliasName;

    @Column(name = "public_flag")
    private Character publicFlag;


    @OneToOne(mappedBy = "group")
    private Post post;


	public Group() {
		// TODO Auto-generated constructor stub
	}


	public Group(Long groupId, String groupName, byte[] objectData, Integer ownerId, String groupAliasName,
			Character publicFlag, Post post) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.objectData = objectData;
		this.ownerId = ownerId;
		this.groupAliasName = groupAliasName;
		this.publicFlag = publicFlag;
		this.post = post;
	}


	public Long getGroupId() {
		return groupId;
	}


	public void setGroupId(Long groupId) {
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


	public Integer getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}


	public String getGroupAliasName() {
		return groupAliasName;
	}


	public void setGroupAliasName(String groupAliasName) {
		this.groupAliasName = groupAliasName;
	}


	public Character getPublicFlag() {
		return publicFlag;
	}


	public void setPublicFlag(Character publicFlag) {
		this.publicFlag = publicFlag;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}



}
