package com.frankstar.spring.boot.action.enums;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public enum Role {

	/**管理员**/
	ADMIN(0, "admin"),


	/**普通**/
	ORDINARY(1, "ordinary"),


	/**会员**/
	MEMBER(2, "member");


	/**
	 * 角色id
	 */
	private int roleId;

	/**
	 * 角色
	 */
	private String role;

	Role(int roleId, String role) {
		this.roleId = roleId;
		this.role = role;
	}

	public static Role fromRoleId(int roleId) {
		for (Role role : Role.values()) {
			if (role.getRoleId() == roleId) return role;
		}
		return null;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
