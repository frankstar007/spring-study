package com.frankstar.spring.boot.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@RestController
public class IndexController {

	@GetMapping(value = "/")
	public String index() {
		return "This is frankstar spring boot admin client";
	}
}
