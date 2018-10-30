package com.rentvalley.service.useraccount;

import com.rentvalley.dto.account.UserAccountDto;

public interface ManageUserAccountService {
	public int isUserAlreadyExists(String userName);
	public int registerUserAccount(UserAccountDto userAccountDto);
	public void activateUser(int userId, String activationCode);
	public int saveSystemUserRole(int userId, int roleNo);
}
