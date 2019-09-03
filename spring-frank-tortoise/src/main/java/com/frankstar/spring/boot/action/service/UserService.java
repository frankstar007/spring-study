package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.processor.UserProcessor;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Service
public class UserService {

	@Resource
	private UserProcessor userProcessor;

	public List<UserDto> loadUsers(List<Integer> userIds) {
		return userProcessor.loadUsers(userIds);
	}

	public UserDto loadUserByName(String username) {
		return userProcessor.loadUserByName(username);
	}


	public boolean register(UserDto user) {
		return userProcessor.addUser(user);
	}
}
