package com.imooc.girl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl, Integer>{

	/**
	 * 通过年龄查询女生列表
	 * @param age
	 * @return
	 */
	public List<Girl> findByAge(Integer age);
}
