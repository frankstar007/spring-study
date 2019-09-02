package com.frankstar.spring.boot.action.dto;

import com.frankstar.spring.boot.action.enums.Role;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails, Serializable{

	private static final long serialVersionUID = -4342330933436022874L;

	private int id;

	private int userId;


	private String password;

	private String avatar;

	private String userName;

	private int age;

	private int sex;

	private String address;

	private String job;

	private Date birthday;

	private int cityId;

	private String cityName;

	private int roleId;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
		List<SimpleGrantedAuthority> simpleAuthorities = Lists.newArrayList();
		int roleId = this.getRoleId();
		Role role = Role.fromRoleId(roleId);
		if (role == null) return Collections.emptyList();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRole());
		simpleAuthorities.add(simpleGrantedAuthority);
		return simpleAuthorities;
	}

	public void setEncodePassword(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePasswd = encoder.encode(password);
		this.password = encodePasswd;
	}

	@Override
	public String getUsername() {
		return this.getUsername();
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
