package com.frankstar.spring.boot.action;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootTortoiseApp.class})
@Slf4j
public class BaseTest {

	public void sysOut(Object o) {
		System.out.println(JSON.toJSONString(o));
	}
}
