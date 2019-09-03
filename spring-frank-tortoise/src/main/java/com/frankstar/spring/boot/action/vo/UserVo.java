package com.frankstar.spring.boot.action.vo;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
@Builder
public class UserVo {


	private int userId;

	private String userName;

	private int age;

	private int sex;

	private String password;

	private int roleId;

	private String email;

	private String phone;

	private String avatar;

	private String address;

	private String job;

	private Date birthday;

	private int cityId;

	private String cityName;
}
