package com.frankstar.spring.boot.action.mapper;

import com.frankstar.spring.boot.action.entity.UserEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public interface UserMapper {


	/**
	 * 批量获取用户
	 * @param userIds
	 * @return
	 */
	List<UserEntity> loadByUserIds(@Param("userIds") List<Integer> userIds);


	/**
	 * 获取某个用户
	 * @param userId
	 * @return
	 */
	UserEntity loadUser(@Param("userId") int userId);

	/**
	 * 新增用户
	 * @param userEntity
	 */
	int insertUser(@Param("userEntity") UserEntity userEntity);

	/**
	 * 通过用户名获取用户
	 * @param userName
	 * @return
	 */
	UserEntity loadUserByName(@Param("userName") String userName);

	/**
	 * 更新用户信息
	 * @param userEntity
	 */
	void updateUser(@Param("userEntity") UserEntity userEntity);
}
