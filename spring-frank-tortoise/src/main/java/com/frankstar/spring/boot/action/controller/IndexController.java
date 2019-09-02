package com.frankstar.spring.boot.action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Controller
public class IndexController {

	@GetMapping("index")
	public String index() {
		return "index";
	}

}
