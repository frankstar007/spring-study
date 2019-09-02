package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.processor.UserProcessor;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Service
public class UserService extends UserDetailsService {

	@Resource
	private UserProcessor userProcessor;

	public List<UserDto> loadUsers(List<Integer> userIds) {
		return userProcessor.loadUsers(userIds);
	}

	public UserDto loadUserByName(String username) {
		return userProcessor.loadUserByName(username);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}
}
