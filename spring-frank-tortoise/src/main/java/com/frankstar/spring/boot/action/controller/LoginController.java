package com.frankstar.spring.boot.action.controller;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.processor.UserProcessor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {

	@Resource
	private UserProcessor userProcessor;

	private static final String LOGIN = "login";

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginPost")
	public ModelAndView login(HttpServletRequest request){
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		ModelAndView modelAndView = new ModelAndView();

		/*用户名不能为空*/
		if (StringUtils.isEmpty(userName)) {
			modelAndView.addObject("error", "用户名不能为空！");
			modelAndView.setViewName(LOGIN);
			return modelAndView;
		}

		/*密码不能为空*/
		if (StringUtils.isEmpty(userName)) {
			modelAndView.addObject("error", "密码不能为空！");
			modelAndView.setViewName(LOGIN);
			return modelAndView;
		}

		/*查询此用户*/
		UserDto userDto = userProcessor.loadUserByName(userName);
		if (userDto == null) {
			modelAndView.addObject("error","无此用户！");
			modelAndView.setViewName("register");
			return modelAndView;
		}

		if (!userDto.getPassword().equals(password)) {
			modelAndView.addObject("error","密码错误！");
			modelAndView.setViewName("login");
			return modelAndView;
		}

		modelAndView.addObject("user", userDto);
		modelAndView.setViewName("/user/homepage");
		return modelAndView;
	}


}
