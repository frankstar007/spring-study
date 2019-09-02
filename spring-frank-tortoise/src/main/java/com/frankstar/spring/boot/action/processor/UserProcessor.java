package com.frankstar.spring.boot.action.processor;

import com.frankstar.spring.boot.action.dto.UserDto;
import com.frankstar.spring.boot.action.entity.UserEntity;
import com.frankstar.spring.boot.action.mapper.UserMapper;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Slf4j
@Component
public class UserProcessor {

	@Autowired
	private UserMapper userMapper;


	public List<UserDto> loadUsers(List<Integer> userIds) {

		try {
			List<UserEntity> userEntities = userMapper.loadByUserIds(userIds);
			if (CollectionUtils.isEmpty(userEntities)) return Collections.emptyList();
			return userEntities.stream().map(
				userEntity -> buildUser(userEntity)
			).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("", e);
		}
		return Collections.emptyList();
	}


	public UserDto loadUser(int userId) {
		try {
			UserEntity userEntity = userMapper.loadUser(userId);
			return buildUser(userEntity);
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	public UserDto loadUserByName(String userName) {
		try {
			UserEntity userEntity = userMapper.loadUserByName(userName);
			return buildUser(userEntity);
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	public boolean addUser(UserDto userDto) {
		if (userDto == null) return true;
		try {
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(userDto, userEntity);
			int result = userMapper.insertUser(userEntity);
			return result > 0;
		} catch (Exception e) {
			log.error("", e);
		}
		return false;
	}

	public boolean update(UserDto userDto) {
		if (userDto == null) return true;
		try {
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(userDto, userEntity);
			userMapper.updateUser(userEntity);
			return true;
		} catch (Exception e) {
			log.error("", e);
		}
		return false;
	}


	private UserDto buildUser(UserEntity userEntity) {
		if (userEntity == null) return null;
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}
}
