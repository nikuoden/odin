package com.odin.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odin.management.entities.User;
import com.odin.management.repositories.UserRepository;

/**
 * ユーザー関連のサービスクラスです。
 *
 * @author k_tsuji
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー名を元にユーザー情報を取得します。
	 *
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}