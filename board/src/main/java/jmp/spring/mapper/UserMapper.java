package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.UserVO;

public interface UserMapper {
	List<UserVO> getUserList();
	
	UserVO getUser(@Param("id") String id, @Param("pwd") String pwd);
	
	int addUser(UserVO user);
}
