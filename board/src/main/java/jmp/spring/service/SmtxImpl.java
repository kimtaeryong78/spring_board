package jmp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmp.spring.mapper.Ex1;
import jmp.spring.mapper.Ex2;
import lombok.Setter;

@Service
public class SmtxImpl implements Smtx{
	
	@Setter(onMethod_ = @Autowired)
	Ex1 ex1;

	@Setter(onMethod_ = @Autowired)
	Ex2 ex2;
	
	@Transactional
	@Override
	public void addData(String value) {
		
		ex2.insert2(value);
		
		ex1.insert1(value);
	}

}
