package com.frankstar.spring.boot.action.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

	private int id;

	private int roleId;

	private String role;

	private Date addTime;

	private Date updateTime;

}
