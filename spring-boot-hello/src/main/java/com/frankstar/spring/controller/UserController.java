package com.frankstar.spring.controller;

import com.frankstar.spring.entity.User;
import com.frankstar.spring.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@RestController
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 查询用户信息
	 */
	@RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
	public User getUser(@PathVariable int userId, HttpServletRequest request) {
		User author = userService.loadUser(userId);
		if(author == null){
			throw new RuntimeException("查询错误");
		}
		return author;
	}
}
