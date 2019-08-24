package com.frankstar.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年08月24日 11:12
 */
@SpringBootApplication
@RestController
public class SpringBootSettingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSettingApplication.class, args);
    }

}
