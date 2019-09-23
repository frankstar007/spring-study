package com.frankstar.spring.boot.frank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.model
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月23日 23:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

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
