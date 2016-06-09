package com.odin.management.autoconfigure.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.odin.management.entities.User;

/**
 * ログイン認証用のユーザークラスです。
 *
 * @author k_tsuji
 *
 */
public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public SecurityUser(User user) {
		if (user != null) {
			this.setId(user.getId());
			this.setUserName(user.getUserName());
			this.setEmail(user.getEmail());
			this.setPassword(user.getPassword());
			this.setRole(user.getRole());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		String userRole = this.getRole();
		if (StringUtils.isNotEmpty(userRole)) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
			authorities.add(authority);
		}

		// 付与された権限を返却
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}