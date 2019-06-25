package com.frankstar.spring.service;

import com.frankstar.spring.dao.UserDao;
import com.frankstar.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User loadUser(int userId) {
		return userDao.findUser(userId);
	}


	public int addUser(User user) {
		return userDao.addUser(user);
	}

}
