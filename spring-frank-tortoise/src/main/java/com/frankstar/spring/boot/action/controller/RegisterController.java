package com.frankstar.spring.boot.action.controller;

import com.frankstar.spring.boot.action.common.constants.TortoiseConstant;
import com.frankstar.spring.boot.action.common.utils.DateUtils;
import com.frankstar.spring.boot.action.common.utils.EncryptUtils;
import com.frankstar.spring.boot.action.common.utils.UserIdUtils;
import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.service.UserService;
import com.frankstar.spring.boot.action.vo.UserVo;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Controller
@RequestMapping("/user")
public class RegisterController {

	private static final String REGISTER = "register";

	@Resource
	private UserService userService;

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping("/registerPost")
	public ModelAndView register(@RequestBody UserVo userVo) {
		String username = userVo.getUserName();
		ModelAndView modelAndView = new ModelAndView();
		/**1 用户名校验**/
		username = username.trim();
		if (StringUtils.isEmpty(username)) {
			modelAndView.addObject("error", "用户名不能为空！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}
		UserDto userDto = userService.loadUserByName(username);
		if (userDto != null) {
			modelAndView.addObject("error", "用户已存在！");
			modelAndView.setViewName("/user/homepage");
			return modelAndView;
		}

		/**2 密码校验 **/
		String password = userVo.getPassword();
		password = password.trim();
		if (StringUtils.isEmpty(password)) {
			modelAndView.addObject("error", "密码不能为空！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}

		/**3 手机号校验 **/
		String phone = userVo.getPhone();
		phone = phone.trim();
		if (StringUtils.isEmpty(phone)) {
			modelAndView.addObject("error", "手机号码不能为空！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}
		/** 手机号正则校验 **/
		if (!checkPhone(phone)) {
			modelAndView.addObject("error", "手机号码格式不正确！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}

		/**4 邮箱校验 **/
		String email = userVo.getEmail();
		email = email.trim();
		if (StringUtils.isEmpty(email)) {
			modelAndView.addObject("error", "邮箱格式不正确！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}

		/** 邮箱正则校验 **/
		if (!checkEmail(email)) {
			modelAndView.addObject("error", "邮箱格式不正确！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}

//		int sex = NumberUtils.toInt(request.getParameter("sex"), 1);
//		int age = NumberUtils.toInt(request.getParameter("age"), 20);
//		String address = request.getParameter("address");
//		String job = request.getParameter("job");
//		Date birthday = DateUtils.format(request.getParameter("birthday"), DateUtils.SIMPLE_FORMAT);
//
//		String cityName = request.getParameter("cityName");
//		if (StringUtils.isEmpty(cityName)) cityName = request.getLocalName();
//
//		String avatar = request.getParameter("avatar");
//		if (StringUtils.isEmpty(avatar)) avatar = TortoiseConstant.TORTOISE_AVATAR;

		/** 正式注册 **/
		UserDto user = UserDto.builder()
			.userId(UserIdUtils.generateUserId())
			.userName(username)
			.password(EncryptUtils.setEncodePassword(password))
			.email(email)
			.phone(phone)
			.sex(userVo.getSex())
			.age(userVo.getAge())
			.address(userVo.getAddress())
			.job(userVo.getJob())
			.birthday(userVo.getBirthday())
			.cityName(userVo.getCityName())
			.avatar(userVo.getAvatar()).build();

		Boolean add = userService.register(user);
		if (!add) {
			modelAndView.addObject("error", "注册服务异常！请重试！");
			modelAndView.setViewName(REGISTER);
			return modelAndView;
		}

		modelAndView.addObject("user", user);
		modelAndView.setViewName("/user/homepage");
		return modelAndView;

	}

	private boolean checkEmail(String email) {
		String emailExp = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-z]{2,}$";
		if (email.matches(emailExp)) {
			return true;
		}
		return false;
	}


	private boolean checkPhone(String phone) {
		String phoneExp = "^(1[3-9])\\\\d{9}$";
		if (phone.matches(phoneExp)) {
			return true;
		}
		return false;
	}
}
