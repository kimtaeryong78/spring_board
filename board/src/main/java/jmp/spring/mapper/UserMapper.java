package jmp.spring.mapper;

import java.util.List;

import jmp.spring.vo.UserVO;

public interface UserMapper {
	List<UserVO> getUserList();
	
	UserVO getUser(UserVO user);
	
	int addUser(UserVO user);
	
	List<String> getUserRole(UserVO user);
}
