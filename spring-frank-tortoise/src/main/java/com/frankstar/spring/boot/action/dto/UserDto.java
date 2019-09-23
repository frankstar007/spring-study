package com.frankstar.spring.boot.action.dto;

import com.frankstar.spring.boot.action.enums.Role;
import java.io.Serializable;
import java.util.*;

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
public class UserDto implements Serializable{

	private static final long serialVersionUID = -4342330933436022874L;

	private int id;

	private int userId;

	private String userName;

	private int age;

	private int sex;

	private String password;

	private int roleId;

	private String email;

	private String phone;

	private String avatar;


	private String address;

	private String job;

	private Date birthday;

	private int cityId;

	private String cityName;

}
