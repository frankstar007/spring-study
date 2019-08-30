package com.frankstar.spring.boot.action.mapper;

import com.frankstar.spring.boot.action.entity.UserEntity;
import java.util.List;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Param;

/**
 * @Author :  frankstar
 * @AddTime :  2019/8/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Table(name = "frankstar_user")
public interface UserMapper {


	List<UserEntity> loadByUserIds(@Param("userIds") List<Integer> userIds);

}
