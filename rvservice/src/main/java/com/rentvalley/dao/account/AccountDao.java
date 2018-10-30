package com.rentvalley.dao.account;


import com.rentvalley.bo.account.ContactInfoBo;
import com.rentvalley.bo.account.UserAccountBo;

public interface AccountDao {
	public UserAccountBo getUserAccount(String userName);
	public int isUserAlreadyExists(String userName);
	public int saveContactInfo(ContactInfoBo contactInfoBo);
	public int saveUserAccount(UserAccountBo userAccountBo, int contactInfoNo);
	public void activateUser(int userId, String activationCode);
	public int saveSystemUserRole(int systemUserNo, int roleNo);
}
