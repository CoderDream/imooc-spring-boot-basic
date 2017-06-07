package com.imooc.girl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
	
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
	public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@RequestParam("id") Integer id) {
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
