package com.frankstar.spring.boot.action.processor;

import com.frankstar.spring.boot.action.BaseTest;
import com.frankstar.spring.boot.action.dto.UserDto;
import java.util.List;
import javax.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public class UserProcessorTest extends BaseTest {

	@Resource
	private UserProcessor userProcessor;

	private static final List<Integer> userIds =
		Lists.newArrayList(123, 22354,435);

	@Test
	public void loadUsers() {
		List<UserDto> userDtos = userProcessor.loadUsers(userIds);
		sysOut(userDtos);
	}

	@Test
	public void loadUser() {
		UserDto userDto = userProcessor.loadUser(1);
		sysOut(userDto);
	}

	@Test
	public void addUser() {
		UserDto userDto = UserDto.builder()
			.userId(2)
			.userName("zoe")
			.address("上海市徐汇区东安路东安一村82号楼306室")
			.cityId(1)
			.cityName("上海")
			.job("architecture").build();
		boolean id = userProcessor.addUser(userDto);
		sysOut(id);
	}

	@Test
	public void updateUser() {
		UserDto userDto = UserDto.builder()
			.userId(1)
			.sex(1)
			.age(28).build();
		boolean result = userProcessor.update(userDto);
		sysOut(result);
	}
}
