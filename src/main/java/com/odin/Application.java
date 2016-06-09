package com.odin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.odin.management.entities.User;
import com.odin.management.repositories.UserRepository;

/**
 *
 * 起動用クラス
 *
 * @author k_tsuji
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Autowired
	UserRepository userRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        List<User> allUsers = userRepository.findAll();

        // ユーザーテーブルに登録無しだった場合adminを自動生成
        // ログイン後に変更する感じ
        if(allUsers == null || allUsers.size() == 0){
        	User user = new User();
        	user.setUserName("sample");
        	user.setPassword("sample");
        	user.setEmail("sample@interspace.ne.jp");

        	user.setRole("ADMIN");
        	userRepository.save(user);
        }
    }
}