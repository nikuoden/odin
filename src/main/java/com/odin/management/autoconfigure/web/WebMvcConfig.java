package com.odin.management.autoconfigure.web;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVCのコンフィグ定義クラスです
 *
 * @author k_tsuji
 *
 */
@Configuration
@ControllerAdvice
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * コントローラークラスの定義が不要な画面の場合、設定すると自動でコントローラーが生成されます。
	 *
	 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");	// /loginにlogin.htmlを定義する
    }

    /**
     * エラー関連のコンフィグ定義
     *
     * @author k_tsuji
     *
     */
	@Configuration
	public static class ErrorConfig implements EmbeddedServletContainerCustomizer {
		@Override
		public void customize(ConfigurableEmbeddedServletContainer factory) {
			// HTTPステータスに対応する静的エラーページを定義
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
		}
	}
}
