package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {	
	@Autowired
	private GirlProperties girlProperties;

	/**
	 * POST方式可以用SoapUI访问，不写的话GET/POST方式都可以访问
	 * @return
	 */
	@RequestMapping(value= "/say")
	public String say(){
		return girlProperties.getCupSize();		
	}
	
}
