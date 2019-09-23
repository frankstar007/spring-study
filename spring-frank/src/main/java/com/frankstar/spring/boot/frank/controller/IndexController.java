package com.frankstar.spring.boot.frank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.controller
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月23日 23:17
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "Hello, frankstar!";
    }
}
