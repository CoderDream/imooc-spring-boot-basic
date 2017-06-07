package com.imooc.girl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl girl1 = new Girl();
		girl1.setCupSize("B");
		girl1.setAge(19);		
		girlRepository.save(girl1);
		
		Girl girl2 = new Girl();
		girl2.setCupSize("F");
		girl2.setAge(20);		
		girlRepository.save(girl2);
	}
}
