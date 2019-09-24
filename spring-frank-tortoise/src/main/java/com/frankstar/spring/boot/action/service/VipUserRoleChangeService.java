package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.VipUserRoleChangeDto;
import com.frankstar.spring.boot.action.response.CommonResponse;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public interface VipUserRoleChangeService {

	/**
	 * 新增用户变更记录
	 * @param vipUserRoleChangeDto
	 * @return
	 */
	CommonResponse<Boolean> addUserChange(VipUserRoleChangeDto vipUserRoleChangeDto);


	/**
	 * 获取用户变更流水
	 * @param userId
	 * @return
	 */
	CommonResponse<List<VipUserRoleChangeDto>> loadUserChangeRecords(long userId);

}
