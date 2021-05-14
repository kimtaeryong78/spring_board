package jmp.spring.vo;

import java.util.*;

import lombok.Data;

@Data
public class UserVO {
	String id;
  	String pwd;
  	String enabled;
	String name;
	String email;
	List<String> userRole;	//권한
	String sessionKey;
	Date sessionLimit;
	
	/**
	 * 권한 확인
	 * @param role_id
	 * @return
	 */
	public boolean hasRole(String role_id) {
		return this.userRole.contains(role_id);
	}
}
