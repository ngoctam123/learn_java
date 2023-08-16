package predev07.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turbine_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_name", nullable = false, length = 32)
    private String loginName;

    @Column(name = "password_value", nullable = false, length = 200)
    private String passwordValue;

    @Column(name = "first_name", nullable = false, length = 99)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 99)
    private String lastName;

    @Column(name = "email", length = 99)
    private String email;

    @Column(name = "confirm_value", length = 99)
    private String confirmValue;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "created")
    private Date created;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "disabled", length = 1)
    private String disabled;

    @Lob
    @Column(name = "objectdata")
    private byte[] objectData;

    @Column(name = "password_changed")
    private Date passwordChanged;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "in_telephone", length = 15)
    private String inTelephone;

    @Column(name = "out_telephone", length = 15)
    private String outTelephone;

    @Column(name = "cellular_phone", length = 15)
    private String cellularPhone;

    @Column(name = "cellular_mail", length = 99)
    private String cellularMail;

    @Column(name = "cellular_uid", length = 99)
    private String cellularUid;

    @Column(name = "first_name_kana", length = 99)
    private String firstNameKana;

    @Column(name = "last_name_kana", length = 99)
    private String lastNameKana;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "has_photo", length = 1)
    private String hasPhoto;

    @Column(name = "photo_modified")
    private Date photoModified;

    @Lob
    @Column(name = "photo_smartphone")
    private byte[] photoSmartphone;

    @Column(name = "has_photo_smartphone", length = 1)
    private String hasPhotoSmartphone;

    @Column(name = "photo_modified_smartphone")
    private Date photoModifiedSmartphone;

    @Column(name = "tutorial_forbid", length = 1)
    private String tutorialForbid;

    @Column(name = "migrate_version", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int migrateVersion;

    @Column(name = "created_user_id")
    private Integer createdUserId;

    @Column(name = "updated_user_id")
    private Integer updatedUserId;

	public User(Long userId, String loginName, String passwordValue, String firstName, String lastName, String email,
			String confirmValue, Date modified, Date created, Date lastLogin, String disabled, byte[] objectData,
			Date passwordChanged, Company company, Position position, String inTelephone, String outTelephone,
			String cellularPhone, String cellularMail, String cellularUid, String firstNameKana, String lastNameKana,
			byte[] photo, String hasPhoto, Date photoModified, byte[] photoSmartphone, String hasPhotoSmartphone,
			Date photoModifiedSmartphone, String tutorialForbid, int migrateVersion, Integer createdUserId,
			Integer updatedUserId) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.passwordValue = passwordValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.confirmValue = confirmValue;
		this.modified = modified;
		this.created = created;
		this.lastLogin = lastLogin;
		this.disabled = disabled;
		this.objectData = objectData;
		this.passwordChanged = passwordChanged;
		this.company = company;
		this.position = position;
		this.inTelephone = inTelephone;
		this.outTelephone = outTelephone;
		this.cellularPhone = cellularPhone;
		this.cellularMail = cellularMail;
		this.cellularUid = cellularUid;
		this.firstNameKana = firstNameKana;
		this.lastNameKana = lastNameKana;
		this.photo = photo;
		this.hasPhoto = hasPhoto;
		this.photoModified = photoModified;
		this.photoSmartphone = photoSmartphone;
		this.hasPhotoSmartphone = hasPhotoSmartphone;
		this.photoModifiedSmartphone = photoModifiedSmartphone;
		this.tutorialForbid = tutorialForbid;
		this.migrateVersion = migrateVersion;
		this.createdUserId = createdUserId;
		this.updatedUserId = updatedUserId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswordValue() {
		return passwordValue;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmValue() {
		return confirmValue;
	}

	public void setConfirmValue(String confirmValue) {
		this.confirmValue = confirmValue;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public byte[] getObjectData() {
		return objectData;
	}

	public void setObjectData(byte[] objectData) {
		this.objectData = objectData;
	}

	public Date getPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(Date passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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

	public String getCellularPhone() {
		return cellularPhone;
	}

	public void setCellularPhone(String cellularPhone) {
		this.cellularPhone = cellularPhone;
	}

	public String getCellularMail() {
		return cellularMail;
	}

	public void setCellularMail(String cellularMail) {
		this.cellularMail = cellularMail;
	}

	public String getCellularUid() {
		return cellularUid;
	}

	public void setCellularUid(String cellularUid) {
		this.cellularUid = cellularUid;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getLastNameKana() {
		return lastNameKana;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getHasPhoto() {
		return hasPhoto;
	}

	public void setHasPhoto(String hasPhoto) {
		this.hasPhoto = hasPhoto;
	}

	public Date getPhotoModified() {
		return photoModified;
	}

	public void setPhotoModified(Date photoModified) {
		this.photoModified = photoModified;
	}

	public byte[] getPhotoSmartphone() {
		return photoSmartphone;
	}

	public void setPhotoSmartphone(byte[] photoSmartphone) {
		this.photoSmartphone = photoSmartphone;
	}

	public String getHasPhotoSmartphone() {
		return hasPhotoSmartphone;
	}

	public void setHasPhotoSmartphone(String hasPhotoSmartphone) {
		this.hasPhotoSmartphone = hasPhotoSmartphone;
	}

	public Date getPhotoModifiedSmartphone() {
		return photoModifiedSmartphone;
	}

	public void setPhotoModifiedSmartphone(Date photoModifiedSmartphone) {
		this.photoModifiedSmartphone = photoModifiedSmartphone;
	}

	public String getTutorialForbid() {
		return tutorialForbid;
	}

	public void setTutorialForbid(String tutorialForbid) {
		this.tutorialForbid = tutorialForbid;
	}

	public int getMigrateVersion() {
		return migrateVersion;
	}

	public void setMigrateVersion(int migrateVersion) {
		this.migrateVersion = migrateVersion;
	}

	public Integer getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}


}
