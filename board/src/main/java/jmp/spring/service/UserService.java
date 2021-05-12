package jmp.spring.service;

import java.util.List;

import jmp.spring.vo.UserVO;

public interface UserService {
	List<UserVO> getList();
	
	UserVO get(UserVO user);
	
	List<String> roles(UserVO user);
}
