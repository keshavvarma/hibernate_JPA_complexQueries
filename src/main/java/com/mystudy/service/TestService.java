/**
 * 
 */
package com.mystudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.TestDao;
import com.mystudy.model.Test;

/**
 * @author om
 *
 */
@Service
public class TestService {
	@Autowired
	TestDao testDao;
	
	public List<Test> findAllTests(){
		return testDao.findAllTests();
	}
}
