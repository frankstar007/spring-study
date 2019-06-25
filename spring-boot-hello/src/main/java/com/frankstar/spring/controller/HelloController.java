package com.frankstar.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot 2.1.6";
	}


}
