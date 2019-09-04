package com.frankstar.spring.boot.action.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
public class UserEntity {

	private int id;

	private int userId;

	private String password;

	private int roleId;

	private String avatar;

	private String userName;

	private String email;

	private String phone;

	private int age;

	private int sex;

	private String address;

	private String job;

	private Date birthday;

	private int cityId;

	private String cityName;


	private Date addTime;

	private Date updateTime;
}
