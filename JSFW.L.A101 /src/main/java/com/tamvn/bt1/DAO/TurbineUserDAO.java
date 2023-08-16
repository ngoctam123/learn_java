package com.tamvn.bt1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tamvn.bt1.DB.DB;
import com.tamvn.bt1.entities.TurbineUser;

@Repository
public class TurbineUserDAO {
    private Connection conn;

    public TurbineUserDAO() {
        conn = DB.getConnection();
    }

    
	public List<TurbineUser> getAllUsers() throws SQLException {
		List<TurbineUser> users = new ArrayList<>();
		String sql = "SELECT * FROM dbo.turbine_user";
		try (
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				TurbineUser user = new TurbineUser();
				user.setUserId(resultSet.getInt("user_id"));
				user.setLoginName(resultSet.getString("login_name"));
				user.setPasswordValue(resultSet.getString("password_value"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
				user.setConfirmValue(resultSet.getString("confirm_value"));
				user.setModified(resultSet.getDate("modified"));
				user.setCreated(resultSet.getDate("created"));
				user.setLastLogin(resultSet.getDate("last_login"));
				user.setDisabled(resultSet.getString("disabled").charAt(0));
				user.setObjectData(resultSet.getBytes("objectdata"));
				user.setPasswordChanged(resultSet.getDate("password_changed"));
				user.setCompanyId(resultSet.getInt("company_id"));
				user.setPositionId(resultSet.getInt("position_id"));
				user.setInTelephone(resultSet.getString("in_telephone"));
				user.setOutTelephone(resultSet.getString("out_telephone"));
				user.setCellularPhone(resultSet.getString("cellular_phone"));
				user.setCellularMail(resultSet.getString("cellular_mail"));
				user.setCellularUid(resultSet.getString("cellular_uid"));
				user.setFirstNameKana(resultSet.getString("first_name_kana"));
				user.setLastNameKana(resultSet.getString("last_name_kana"));
				user.setPhoto(resultSet.getBytes("photo"));
				user.setHasPhoto(resultSet.getString("has_photo").charAt(0));
				user.setPhotoModified(resultSet.getDate("photo_modified"));
				user.setPhotoSmartphone(resultSet.getBytes("photo_smartphone"));
				user.setHasPhotoSmartphone(resultSet.getString("has_photo_smartphone").charAt(0));
				user.setPhotoModifiedSmartphone(resultSet.getDate("photo_modified_smartphone"));
				user.setTutorialForbid(resultSet.getString("tutorial_forbid").charAt(0));
				user.setMigrateVersion(resultSet.getInt("migrate_version"));
				user.setCreatedUserId(resultSet.getInt("created_user_id"));
				user.setUpdatedUserId(resultSet.getInt("updated_user_id"));
				users.add(user);
			}
		}
		return users;
	}

	public TurbineUser getUserById(int userId) throws SQLException {
		TurbineUser user = null;
		String sql = "SELECT * FROM dbo.turbine_user WHERE user_id = ?";
		try (
				PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, userId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					user = new TurbineUser();
					user.setUserId(resultSet.getInt("user_id"));
					user.setLoginName(resultSet.getString("login_name"));
					user.setPasswordValue(resultSet.getString("password_value"));
					user.setFirstName(resultSet.getString("first_name"));
					user.setLastName(resultSet.getString("last_name"));
					user.setEmail(resultSet.getString("email"));
					user.setConfirmValue(resultSet.getString("confirm_value"));
					user.setModified(resultSet.getDate("modified"));
					user.setCreated(resultSet.getDate("created"));
					user.setLastLogin(resultSet.getDate("last_login"));
					user.setDisabled(resultSet.getString("disabled").charAt(0));
					user.setObjectData(resultSet.getBytes("objectdata"));
					user.setPasswordChanged(resultSet.getDate("password_changed"));
					user.setCompanyId(resultSet.getInt("company_id"));
					user.setPositionId(resultSet.getInt("position_id"));
					user.setInTelephone(resultSet.getString("in_telephone"));
					user.setOutTelephone(resultSet.getString("out_telephone"));
					user.setCellularPhone(resultSet.getString("cellular_phone"));
					user.setCellularMail(resultSet.getString("cellular_mail"));
					user.setCellularUid(resultSet.getString("cellular_uid"));
					user.setFirstNameKana(resultSet.getString("first_name_kana"));
					user.setLastNameKana(resultSet.getString("last_name_kana"));
					user.setPhoto(resultSet.getBytes("photo"));
					user.setHasPhoto(resultSet.getString("has_photo").charAt(0));
					user.setPhotoModified(resultSet.getDate("photo_modified"));
					user.setPhotoSmartphone(resultSet.getBytes("photo_smartphone"));
					user.setHasPhotoSmartphone(resultSet.getString("has_photo_smartphone").charAt(0));
					user.setPhotoModifiedSmartphone(resultSet.getDate("photo_modified_smartphone"));
					user.setTutorialForbid(resultSet.getString("tutorial_forbid").charAt(0));
					user.setMigrateVersion(resultSet.getInt("migrate_version"));
					user.setCreatedUserId(resultSet.getInt("created_user_id"));
					user.setUpdatedUserId(resultSet.getInt("updated_user_id"));
				}
			}
		}
		return user;
	}


	public void addUser(TurbineUser user) throws SQLException {
		String sql = "INSERT INTO dbo.turbine_user (user_id, login_name, password_value, first_name, last_name, email, confirm_value, modified, created, last_login, disabled, objectdata, password_changed, company_id, position_id, in_telephone, out_telephone, cellular_phone, cellular_mail, cellular_uid, first_name_kana, last_name_kana, photo, has_photo, photo_modified, photo_smartphone, has_photo_smartphone, photo_modified_smartphone, tutorial_forbid, migrate_version, created_user_id, updated_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
				PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getLoginName());
			statement.setString(3, user.getPasswordValue());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getConfirmValue());
			statement.setDate(8, new java.sql.Date(user.getModified().getTime()));
			statement.setDate(9, new java.sql.Date(user.getCreated().getTime()));
			statement.setDate(10, new java.sql.Date(user.getLastLogin().getTime()));
			statement.setString(11, String.valueOf(user.getDisabled()));
			statement.setBytes(12, user.getObjectData());
			statement.setDate(13, new java.sql.Date(user.getPasswordChanged().getTime()));
			statement.setInt(14, user.getCompanyId());
			statement.setInt(15, user.getPositionId());
			statement.setString(16, user.getInTelephone());
			statement.setString(17, user.getOutTelephone());
			statement.setString(18, user.getCellularPhone());
			statement.setString(19, user.getCellularMail());
			statement.setString(20, user.getCellularUid());
			statement.setString(21, user.getFirstNameKana());
			statement.setString(22, user.getLastNameKana());
			statement.setBytes(23, user.getPhoto());
			statement.setDate(24, new java.sql.Date(user.getPhotoModified().getTime()));
			statement.setBytes(25, user.getPhotoSmartphone());
			statement.setString(26, String.valueOf(user.getHasPhotoSmartphone()));
			statement.setDate(27, new java.sql.Date(user.getPhotoModifiedSmartphone().getTime()));
			statement.setString(28, String.valueOf(user.getTutorialForbid()));
			statement.setInt(29, user.getMigrateVersion());
			statement.setInt(30, user.getCreatedUserId());
			statement.setInt(31, user.getUpdatedUserId());
			statement.executeUpdate();
		}
		
	}

	public void updateUser(TurbineUser user) throws SQLException {
		String sql = "UPDATE dbo.turbine_user SET login_name = ?, password_value = ?, first_name = ?, last_name = ?, email = ?, confirm_value = ?, modified = ?, created = ?, last_login = ?, disabled = ?, objectdata = ?, password_changed = ?, company_id = ?, position_id = ?, in_telephone = ?, out_telephone = ?, cellular_phone = ?, cellular_mail = ?, cellular_uid = ?, first_name_kana = ?, last_name_kana = ?, photo = ?, has_photo = ?, photo_modified = ?, photo_smartphone = ?, has_photo_smartphone = ?, photo_modified_smartphone = ?, tutorial_forbid = ?, migrate_version = ?, created_user_id = ?, updated_user_id = ? WHERE user_id = ?";
		try (
				PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, user.getLoginName());
			statement.setString(2, user.getPasswordValue());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getConfirmValue());
			statement.setDate(7, new java.sql.Date(user.getModified().getTime()));
			statement.setDate(8, new java.sql.Date(user.getCreated().getTime()));
			statement.setDate(9, new java.sql.Date(user.getLastLogin().getTime()));
			statement.setString(10, String.valueOf(user.getDisabled()));
			statement.setBytes(11, user.getObjectData());
			statement.setDate(12, new java.sql.Date(user.getPasswordChanged().getTime()));
			statement.setInt(13, user.getCompanyId());
			statement.setInt(14, user.getPositionId());
			statement.setString(15, user.getInTelephone());
			statement.setString(16, user.getOutTelephone());
			statement.setString(17, user.getCellularPhone());
			statement.setString(18, user.getCellularMail());
			statement.setString(19, user.getCellularUid());
			statement.setString(20, user.getFirstNameKana());
			statement.setString(21, user.getLastNameKana());
			statement.setBytes(22, user.getPhoto());
			statement.setString(23, String.valueOf(user.getHasPhoto()));
			statement.setDate(24, new java.sql.Date(user.getPhotoModified().getTime()));
			statement.setBytes(25, user.getPhotoSmartphone());
			statement.setString(26, String.valueOf(user.getHasPhotoSmartphone()));
			statement.setDate(27, new java.sql.Date(user.getPhotoModifiedSmartphone().getTime()));
			statement.setString(28, String.valueOf(user.getTutorialForbid()));
			statement.setInt(29, user.getMigrateVersion());
			statement.setInt(30, user.getCreatedUserId());
			statement.setInt(31, user.getUpdatedUserId());
			statement.setInt(32, user.getUserId());
			statement.executeUpdate();
		}
		
	}

	public void deleteUser(int userId) throws SQLException {
		String sql = "DELETE FROM dbo.turbine_user WHERE user_id = ?";
		try (
				PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, userId);
			statement.executeUpdate();
		}
	}
}
