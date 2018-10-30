package com.rentvalley.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rentvalley.bo.account.ContactInfoBo;
import com.rentvalley.bo.account.RoleBo;
import com.rentvalley.bo.account.UserAccountBo;
import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.logger.RentvalleyLogger;

@Repository
public class AccountDaoImpl implements AccountDao {
	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(AccountDaoImpl.class);

	private final String GET_USER_WITH_ROLE = "select su.username, r.role_no, r.role_nm, su.password, su.first_name, su.last_name, su.status from system_user_role u inner join role r on u.role_no = r.role_no inner join system_user su on su.system_user_no = u.system_user_no where su.username = ? and r.role_nm in ('rentee')";
	private final String IS_USER_EXISTS = "select count(1) from system_user where username = ? ";
	private final String INSERT_CONTACT_INFO = "insert into contact_info (contact_no, email_address, created_by, created_dt, last_modified_by, last_modified_dt) values (?,?,?,?,?,?)";
	private final String INSERT_USER_INFO = "insert into system_user (username, password, first_name, last_name, primary_contact_info_no, registered_dt, activated_dt, activation_code, status, created_by, created_dt, last_modified_by, last_modified_dt) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_RENTEE_STATUS = "update system_user set status = ? where system_user_no = ? and activation_code = ? ";
	private final String INSERT_SYSTEM_USER_ROLE = "insert into system_user_role(system_user_no, role_no, created_by, created_dt, last_modified_by, last_modified_dt) values (?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserAccountBo getUserAccount(String userName) {
		return jdbcTemplate.queryForObject(GET_USER_WITH_ROLE, new RowMapper<UserAccountBo>() {

			@Override
			public UserAccountBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserAccountBo userAccountBo = null;
				RoleBo roleBo = null;

				roleBo = new RoleBo(rs.getInt("r.role_no"), rs.getString("r.role_nm"));
				userAccountBo = new UserAccountBo();
				userAccountBo.setUserName(rs.getString("su.username"));
				userAccountBo.setPassword(rs.getString("su.password"));
				userAccountBo.setRoleBo(roleBo);
				userAccountBo.setStatus(rs.getString("su.status"));
				return userAccountBo;
			}
		}, new Object[] { userName });
	}

	@Override
	public int saveContactInfo(ContactInfoBo contactInfoBo) {
		logger.info("saving contact_info table information");

		KeyHolder keyHolder = null;
		keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				pstmt = con.prepareStatement(INSERT_CONTACT_INFO, new String[] { "contact_info_no" });
				// set the values prepared statement
				pstmt.setString(1, contactInfoBo.getContactNo());
				pstmt.setString(2, contactInfoBo.getEmailAddress());
				pstmt.setString(3, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(4, new java.sql.Date(new Date().getTime()));
				pstmt.setString(5, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
				logger.info("accountDaoImpl.saveContactInfo() : setting prepared stmt values got completed");
				return pstmt;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	@Override
	public int saveUserAccount(final UserAccountBo userAccountBo, final int contactInfoNo) {
		KeyHolder keyHolder = null;

		keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = con.prepareStatement(INSERT_USER_INFO, new String[] { "system_user_no" });
				// setting up the values
				pstmt.setString(1, userAccountBo.getUserName());
				pstmt.setString(2, userAccountBo.getPassword());
				pstmt.setString(3, userAccountBo.getFirstName());
				pstmt.setString(4, userAccountBo.getLastName());
				pstmt.setInt(5, contactInfoNo);
				pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
				pstmt.setDate(7, new java.sql.Date(new Date().getTime()));
				pstmt.setString(8, userAccountBo.getActivationCode());
				//pstmt.setString(9, "R");
				pstmt.setString(9, RentValleyStaticConstants.USER_REGISTERED_STATUS);
				pstmt.setString(10, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(11, new java.sql.Date(new Date().getTime()));
				pstmt.setString(12, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(13, new java.sql.Date(new Date().getTime()));

				return pstmt;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	@Override
	public void activateUser(final int userId, final String activationCode) {
		jdbcTemplate.update(UPDATE_RENTEE_STATUS, new Object[] {RentValleyStaticConstants.USER_ACTIVATED_STATUS, userId, activationCode });
	}

	@Override
	public int saveSystemUserRole(final int systemUserNo, final int roleNo) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = con.prepareStatement(INSERT_SYSTEM_USER_ROLE);
				pstmt.setInt(1, systemUserNo);
				pstmt.setInt(2, roleNo);
				pstmt.setString(3, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(4, new java.sql.Date(new Date().getTime()));
				pstmt.setString(5, RentValleyStaticConstants.SYSTEM_USER);
				pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
				return pstmt;
			}
		});
		return systemUserNo;
	}

	
	@Override
	public int isUserAlreadyExists(String userName) {
		return jdbcTemplate.queryForObject(IS_USER_EXISTS, new Object[] {userName}, Integer.class);
	}

	
}
