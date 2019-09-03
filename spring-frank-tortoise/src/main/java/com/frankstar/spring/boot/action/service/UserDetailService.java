package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.enums.Role;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Slf4j
@Component
public class UserDetailService implements UserDetailsService {

	@Resource
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username = {}", username);
		UserDto userDto = userService.loadUserByName(username);
		if (userDto == null) {
			return null;
		}
		return new UserDetails() {

			private static final long serialVersionUID = -3661298233949989219L;

			/** 用户权限集合 **/
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				int roleId = userDto.getRoleId();
				Role role = Role.fromRoleId(roleId);
				if (role != null) {
					SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRole());
					return Lists.newArrayList(simpleGrantedAuthority);
				}
				return Collections.emptyList();
			}

			@Override
			public String getPassword() {
				return userDto.getPassword();
			}

			@Override
			public String getUsername() {
				return userDto.getUserName();
			}

			/** 账户未过期 **/
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			/** 账户未锁定 **/
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			/** 凭据未过期 **/
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			/** 账户可用 **/
			@Override
			public boolean isEnabled() {
				return true;
			}
		};
	}
}
