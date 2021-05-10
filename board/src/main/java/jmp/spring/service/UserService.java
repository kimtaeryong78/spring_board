package jmp.spring.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.UserVO;

public interface UserService {
	List<UserVO> getList();
	
	UserVO get(@Param("id") String id, @Param("pwd") String pwd);
}
