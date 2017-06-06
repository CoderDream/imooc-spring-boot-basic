package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
	
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value= {"/hello","/hi"}, method=RequestMethod.GET)
	public String say(){
		return girlProperties.getCupSize();
		
	}
	
}
