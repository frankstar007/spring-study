package com.frankstar.spring.boot.frank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月23日 23:02
 */
@SpringBootApplication
@MapperScan(basePackages = "com.frankstar.spring.boot.frank.mapper")
public class SpringFrankApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFrankApplication.class);
    }
}
