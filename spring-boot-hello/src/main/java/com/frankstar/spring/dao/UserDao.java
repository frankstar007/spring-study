package com.frankstar.spring.dao;

import com.frankstar.spring.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public interface UserDao {

	int addUser(@Param("user") User user);

	User findUser(@Param("userId") int userId);


}
