package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.UserVO;

public interface UserMapper {
	List<UserVO> getUserList();
	
	UserVO getUser(UserVO user);
	
	int addUser(UserVO user);
	
	int addtUserRole(@Param("id") String id, @Param("role") String rol);
	
	List<String> getUserRole(UserVO user);
	
	int autoLogin(UserVO user);
	
	UserVO getSessionKey(UserVO user);
	
	int updateUser(UserVO user);
}
