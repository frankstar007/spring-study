package com.frankstar.spring.boot.frank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.entity
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月24日 00:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
