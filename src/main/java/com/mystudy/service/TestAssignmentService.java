/**
 * 
 */
package com.mystudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.TestAssignmentDao;
import com.mystudy.model.TestAssignment;

/**
 * @author om
 *
 */
@Service
public class TestAssignmentService {
	@Autowired
	TestAssignmentDao testAssignmentDao;
	
	public List<TestAssignment> findAllByAssignedTestByTeamId(Long teamId){
		return testAssignmentDao.findAllByAssignedTestByTeamId(teamId);
	}
}
