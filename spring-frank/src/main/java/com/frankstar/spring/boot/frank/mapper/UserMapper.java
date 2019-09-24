package com.frankstar.spring.boot.frank.mapper;

import com.frankstar.spring.boot.frank.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.mapper
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月24日 00:22
 */
public interface UserMapper {

    /**
     * 添加用户
     * @param userEntity
     */
    void addUser(@Param("userEntity") UserEntity userEntity);


    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(@Param("userId") int userId);


    /**
     * 更新用户信息
     * @param userEntity
     */
    void updateUser(@Param("userEntity") UserEntity userEntity);


    /**
     * 根据userId获取用户
     * @param userId
     * @return
     */
    UserEntity loadUser(@Param("userId") int userId);


    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    UserEntity loadUserByName(@Param("userName") String userName);

    /**
     * 批量获取用户
     * @param userIds
     * @return
     */
    List<UserEntity> loadUsers(@Param("userIds") List<Integer> userIds);

    /**
     * 获取所有用户
     * @return
     */
    List<UserEntity> loadAllUsers();
}
