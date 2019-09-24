package com.frankstar.spring.boot.frank.processor;

import com.frankstar.spring.boot.frank.entity.UserEntity;
import com.frankstar.spring.boot.frank.mapper.UserMapper;
import com.frankstar.spring.boot.frank.model.User;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import org.springframework.util.CollectionUtils;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.processor
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月24日 00:33
 */
@Slf4j
@Component
public class UserProcessor {

    @Resource
    private UserMapper userMapper;

    public User loadUser(int userId) {
        try {
            UserEntity userEntity = userMapper.loadUser(userId);
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            return user;
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

    public List<User> loadAllUsers() {
        try {
            List<UserEntity> userEntities = userMapper.loadAllUsers();
            if (CollectionUtils.isEmpty(userEntities)) return Collections.emptyList();
            return userEntities.stream().map(
                userEntity -> {
                    User user = new User();
                    BeanUtils.copyProperties(userEntity, user);
                    return user;
                }
            ).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("", e);
        }
        return Collections.emptyList();
    }


    public boolean addUser(User user) {
        if (user == null) return false;
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userMapper.addUser(userEntity);
            return true;
        } catch (Exception e) {
            log.error("", e);
        }
        return false;
    }


}
