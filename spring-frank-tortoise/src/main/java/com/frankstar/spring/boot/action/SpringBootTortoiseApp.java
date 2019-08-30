package com.frankstar.spring.boot.action;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@SpringBootApplication
@MapperScan("com.frankstar.spring.boot.action.mapper")
public class SpringBootTortoiseApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTortoiseApp.class, args);
	}
}
