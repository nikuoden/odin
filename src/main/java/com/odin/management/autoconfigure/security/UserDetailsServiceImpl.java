package com.odin.management.autoconfigure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.odin.management.entities.User;
import com.odin.management.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findUserByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーが見つかりません。");
		}
		return new SecurityUser(user);
	}
}
