package com.rentvalley.dto.security.account;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	protected String username;
	protected String password;
	protected int locked;
	protected int disabled;
	protected String roleName;
	protected String status;
	protected Collection<SimpleGrantedAuthority> authorities;

	public UserDetailsImpl(String username, String password, String roleName, String status) {
		//super();
		this.username = username;
		this.password = password;
		this.roleName = roleName;
		this.status = status;
		System.out.println(status);
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		if(status.equalsIgnoreCase("A")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(status.equalsIgnoreCase("A")) {
			return true;
		}
		/*if (locked == 1) {
			return false;
		}*/
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		/*if (disabled == 1) {
			return false;
		}*/
		return true;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [username=" + username + ", password=" + password + ", locked=" + locked + ", disabled="
				+ disabled + ", roleName=" + roleName + ", authorities=" + authorities + "]";
	}
	
}
