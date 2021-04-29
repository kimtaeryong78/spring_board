package jmp.spring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Ex1 {
	@Insert("insert into ex1 values (${data})")
	public int insert1(String data);
}
