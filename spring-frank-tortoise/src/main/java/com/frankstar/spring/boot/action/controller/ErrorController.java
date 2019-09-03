package com.frankstar.spring.boot.action.controller;

import com.frankstar.spring.boot.action.dto.ErrorMsg;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/error")
public class ErrorController {


	@GetMapping("/404")
	public ModelAndView error404() {
		ModelAndView modelAndView = new ModelAndView();
		ErrorMsg errorMsg = buildErr(HttpStatus.NOT_FOUND);
		modelAndView.addObject("err", errorMsg);
		modelAndView.setViewName("/error/error404");
		return modelAndView;
	}

	@GetMapping("/500")
	public ModelAndView error500() {
		ModelAndView modelAndView = new ModelAndView();
		ErrorMsg errorMsg = buildErr(HttpStatus.INTERNAL_SERVER_ERROR);
		modelAndView.addObject("err", errorMsg);
		modelAndView.setViewName("/error/error500");
		return modelAndView;
	}


	private ErrorMsg buildErr(HttpStatus httpStatus) {
		return ErrorMsg.builder()
			.error(httpStatus.getReasonPhrase())
			.messages(httpStatus.name())
			.timestamp(new Date())
			.title(String.valueOf(httpStatus.value()))
			.status(httpStatus.value()).build();
	}
}
