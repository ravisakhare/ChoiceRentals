package com.rentvalley.service.security.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rentvalley.bo.account.UserAccountBo;
import com.rentvalley.dao.account.AccountDao;
import com.rentvalley.dto.security.account.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccountBo userBo = null;
		UserDetails userDetails = null;

		userBo = accountDao.getUserAccount(username);
		if (userBo == null) {
			throw new UsernameNotFoundException("username not found exception");
		}
		userDetails = new UserDetailsImpl(userBo.getUserName(), userBo.getPassword(), userBo.getRoleBo().getRoleName(), userBo.getStatus());
		return userDetails;
	}
}
