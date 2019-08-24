package com.frankstar.spring.boot;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot
 * @Description: SpringBoot启动类
 * @mail :  frankstar007@163.com
 * @date Date : 2019年08月24日 10:38
 */
@SpringBootApplication
@RestController
public class SpringBootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, name = "name") String name) {
        if (StringUtils.isEmpty(name)) {
            return "frankstar";
        }
        return StrUtil.format("Hello, {}", name);
    }

}


