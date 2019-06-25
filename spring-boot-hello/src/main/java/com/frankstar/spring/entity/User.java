package com.frankstar.spring.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
public class User {

	private int id;

	private int userId;

	private String login;

	private String password;

	private String userName;

	private String address;

	private String job;

	private int groupId;

	private Date birthday;

	private int cityId;

	private String cityName;

	private String district;

	private String province;

	private String streetAddress;

	private String state;

	private int type;

	private Date lasLoginState;

	private Date addTime;

	private Date updateTime;
}
