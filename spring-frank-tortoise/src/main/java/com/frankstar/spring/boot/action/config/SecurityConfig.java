package com.frankstar.spring.boot.action.config;

import com.frankstar.spring.boot.action.common.constants.SecurityConstant;
import com.frankstar.spring.boot.action.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc : 安全配置类
 *  启用方法安全配置
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	private UserDetailsService userDetailsService;


	@Bean
	public PasswordEncoder passwordEncoder() {
		//使用BCrypt加密
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}

	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//都可以访问 // 需要相应的角色才能访问 禁用 H2 控制台的 CSRF 防护允许来自同一来源的H2 控制台的请求
		http.authorizeRequests().antMatchers("/","/css/**", "/js/**", "/fonts/**","/users").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/console/**").hasAnyRole("ADMIN","USER")
				.and()
				.formLogin()   //基于 Form 表单登录验证
				.loginPage("/user/login").failureUrl("/user/register")
				.and().rememberMe().key(SecurityConstant.SALT)
				.and().exceptionHandling().accessDeniedPage("/403");
		//http.csrf().ignoringAntMatchers("/h2-console/**");
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
	}
	/**
	 * 认证信息管理
	 *
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("frankstar").password("frankstar").roles("admin");
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
}
