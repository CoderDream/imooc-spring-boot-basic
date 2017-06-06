package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String say(){
		//return girlProperties.getCupSize();
		return "index";
	}
	
}
