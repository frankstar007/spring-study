package com.frankstar.spring.boot.action.controller;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.processor.UserProcessor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Controller
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserProcessor userProcessor;

	@RequestMapping(value = "/homepage")
	public ModelAndView homepage(HttpServletRequest req) {
		String username = req.getParameter("username");
		UserDto user = userProcessor.loadUserByName(username);
		ModelAndView mv = new ModelAndView();

		if (user == null) {
			mv.addObject("error","无此用户！");
			mv.setViewName("register");
			return mv;
		}

		mv.addObject("user", user);
		mv.setViewName("/user/homepage");
		return mv;
	}


}
