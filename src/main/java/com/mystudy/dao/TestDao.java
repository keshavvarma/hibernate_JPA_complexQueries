/**
 * 
 */
package com.mystudy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.model.Test;
import com.mystudy.repository.TestRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class TestDao{
	@Autowired
	TestRepository testRepository;
	
	public Test save(Test test) {
		return testRepository.save(test);
	}
}
