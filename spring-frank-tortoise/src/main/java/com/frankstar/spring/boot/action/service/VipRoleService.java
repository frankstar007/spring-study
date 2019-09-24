package com.frankstar.spring.boot.action.service;

import com.frankstar.spring.boot.action.dto.VipRoleDto;
import com.frankstar.spring.boot.action.response.CommonResponse;
import java.util.List;
import sun.jvm.hotspot.types.basic.BasicOopField;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public interface VipRoleService {


	/**
	 * 新增VIP身份
	 * @param vipRoleDto
	 * @return
	 */
	CommonResponse<Boolean> addNewRole(VipRoleDto vipRoleDto);


	/**
	 * 获取某种角色信息
	 * @param roleId
	 * @return
	 */
	CommonResponse<VipRoleDto> loadVipRoleInfo(int roleId);


	/**
	 * 批量获取角色信息
	 * @param roleIds
	 * @return
	 */
	CommonResponse<List<VipRoleDto>> batchLoad(List<Integer> roleIds);
}
