/**
 * 
 */
package com.mystudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.TestDao;
import com.mystudy.model.Test;

/**
 * @author Keshav
 *
 */
@Service
public class TestService {
	@Autowired
	TestDao testDao;
	
	public Test saveTest() {
		Test test = new Test();
		test.setTestName("6A");
		test.setCallidoLevel(6);
		return testDao.save(test);
	}
}
