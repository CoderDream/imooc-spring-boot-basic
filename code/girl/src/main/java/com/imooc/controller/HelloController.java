package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.properties.GirlProperties;

@RestController
@RequestMapping("/hello")
public class HelloController {	
	@Autowired
	private GirlProperties girlProperties;

	/**
	 * POST方式可以用SoapUI访问，不写的话GET/POST方式都可以
	 * @return
	 */
	@RequestMapping(value= "/{id}/say", method=RequestMethod.GET)
	public String say(@PathVariable("id") Integer id){
		//return girlProperties.getCupSize();
		return "id: " + id;
	}
	
	@RequestMapping(value= "/say02", method=RequestMethod.GET)
	public String say02(@RequestParam("id") Integer id){
		//return girlProperties.getCupSize();
		return "id: " + id;
	}
	

	@RequestMapping(value= "/say03", method=RequestMethod.GET)
	public String say03(@RequestParam(value="id", required=false, defaultValue="0") Integer id){
		//return girlProperties.getCupSize();
		return "id: " + id;
	}
	

	@GetMapping(value= "/say04")
	public String say04(@RequestParam(value="id", required=false, defaultValue="0") Integer id){
		//return girlProperties.getCupSize();
		return "id: " + id;
	}
	
}
