package jmp.spring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Ex2 {
	@Insert("insert into ex2 values (${data})")
	public int insert2(String data);
}
