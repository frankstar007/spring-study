package com.frankstar.spring.boot.action.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Entity
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "password")
	private String password;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "username")
	private String userName;

	@Column(name = "address")
	private String address;

	@Column(name = "job")
	private String job;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "last_login_date")
	private Date lastLoginDate;

	@Column(name = "add_time")
	private Date addTime;

	@Column(name = "update_time")
	private Date updateTime;
}
