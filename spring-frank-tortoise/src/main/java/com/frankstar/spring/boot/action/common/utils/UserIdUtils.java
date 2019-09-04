package com.frankstar.spring.boot.action.common.utils;

import java.util.Random;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public class UserIdUtils {

	public static int generateUserId() {
		int userId = new Random().nextInt();
		userId  = Math.abs(userId);
		return userId;
	}

}
