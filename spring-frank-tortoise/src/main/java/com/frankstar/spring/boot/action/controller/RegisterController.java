package com.frankstar.spring.boot.action.controller;

import com.frankstar.spring.boot.action.common.constants.TortoiseConstant;
import com.frankstar.spring.boot.action.common.utils.DateUtils;
import com.frankstar.spring.boot.action.common.utils.EncryptUtils;
import com.frankstar.spring.boot.action.common.utils.UserIdUtils;
import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.response.CommonResponse;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/registerPost", method = RequestMethod.POST)
	public CommonResponse<Boolean> registerPost(@RequestBody UserVo userVo) {
		String username = userVo.getUsername();
		ModelAndView modelAndView = new ModelAndView();
		/**1 用户名校验**/
		username = username.trim();
		if (StringUtils.isEmpty(username)) {
			return CommonResponse.buildFailResponse(500, "用户名不能为空！");
//			modelAndView.addObject("error", "");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}
		UserDto userDto = userService.loadUserByName(username);
		if (userDto != null) {
			return CommonResponse.buildFailResponse(501, "用户已存在！");
//			modelAndView.addObject("error", "用户已存在！");
//			modelAndView.setViewName("/user/homepage");
//			return modelAndView;
		}

		/**2 密码校验 **/
		String password = userVo.getPassword();
		password = password.trim();
		if (StringUtils.isEmpty(password)) {
			return CommonResponse.buildFailResponse(500, "密码不能为空！");
//			modelAndView.addObject("error", "密码不能为空！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}

		/**3 手机号校验 **/
		String phone = userVo.getPhone();
		phone = phone.trim();
		if (StringUtils.isEmpty(phone)) {
			return CommonResponse.buildFailResponse(500, "手机号码不能为空！");
//			modelAndView.addObject("error", "手机号码不能为空！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}
		/** 手机号正则校验 **/
		if (!checkPhone(phone)) {
			return CommonResponse.buildFailResponse(500, "手机号码格式不正确！");
//			modelAndView.addObject("error", "手机号码格式不正确！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}

		/**4 邮箱校验 **/
		String email = userVo.getEmail();
		email = email.trim();
		if (StringUtils.isEmpty(email)) {
			return CommonResponse.buildFailResponse(500, "邮箱格式不能为空！");
//			modelAndView.addObject("error", "邮箱格式不正确！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}

		/** 邮箱正则校验 **/
		if (!checkEmail(email)) {
			return CommonResponse.buildFailResponse(500, "邮箱格式不正确");
//			modelAndView.addObject("error", "邮箱格式不正确！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}

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
			return CommonResponse.buildFailResponse(500, "注册服务异常！");
//			modelAndView.addObject("error", "注册服务异常！请重试！");
//			modelAndView.setViewName(REGISTER);
//			return modelAndView;
		}
		return CommonResponse.buildSuccessResponse(true);
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("/user/homepage");
//		return modelAndView;

	}

	private static boolean checkEmail(String email) {
		String emailExp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if (email.matches(emailExp)) {
			return true;
		}
		return false;
	}


	private static boolean checkPhone(String phone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
		if (phone.matches(regex)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String email = "568106896@qq.com";
		System.out.println(checkEmail(email));
	}
}
