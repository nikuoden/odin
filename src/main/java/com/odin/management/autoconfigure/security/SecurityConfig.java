package com.odin.management.autoconfigure.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsServiceImpl customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
    	security.authorizeRequests()
    	.antMatchers("**api**").permitAll()
    	.anyRequest().authenticated()	// どんなリクエストも認証済みであること;
        .and()
        .formLogin()
        .defaultSuccessUrl("/management/", true)
        .loginPage("/login")			// ログインページのURL
        .permitAll()					// ここだけ認証済みでなくてよい
        .and()
        .logout()
        .permitAll();

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        security.addFilterBefore(filter, CsrfFilter.class);
    }

    @Override
    public void configure(WebSecurity security){
    	security.ignoring().antMatchers("/css/**","/js/**","/img/**");
    }
}