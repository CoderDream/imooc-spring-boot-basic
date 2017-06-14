package com.imooc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;

@RestController
public class GirlController {
	
	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;

	/**
	 * 所有女生列表
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}
	
	/**
	 * 添加一个女生
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			Result<Girl> result = new Result<Girl>(); 
			result.setCode(1);
			result.setMsg(bindingResult.getFieldError().getDefaultMessage());
			return result;
		}
		
		girl.setAge(girl.getAge());
		girl.setCupSize(girl.getCupSize());
		
		Result<Girl> result = new Result<Girl>(); 
		result.setCode(0);
		result.setMsg("成功");
		result.setData(girlRepository.save(girl));
		
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		//System.out.println("girlFindOne");
		logger.info("girlFindOne");
		return girlRepository.findOne(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
	}
	
	
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	
	/**
	 * 所有女生列表
	 * @return
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}
	
	/**
	 * 添加两个女生
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls/two")
	public void girlTwo() {
		girlService.insertTwo();		
	}
	
}
