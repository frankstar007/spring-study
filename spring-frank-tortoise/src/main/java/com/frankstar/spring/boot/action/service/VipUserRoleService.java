package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.VipUserRoleDto;
import com.frankstar.spring.boot.action.response.CommonResponse;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public interface VipUserRoleService {

	/**
	 * 新增vip身份用户
	 * @param vipUserRoleDto
	 * @return
	 */
	CommonResponse<Boolean> addVipUser(VipUserRoleDto vipUserRoleDto);


	/**
	 * 获取指定用户的vip信息
	 * @param userId
	 * @return
	 */
	CommonResponse<VipUserRoleDto> loadVipUser(long userId);


	/**
	 * 变更用户的vip信息
	 * @param vipUserRoleDto
	 * @return
	 */
	CommonResponse<Boolean> updateVipUser(VipUserRoleDto vipUserRoleDto);

}
