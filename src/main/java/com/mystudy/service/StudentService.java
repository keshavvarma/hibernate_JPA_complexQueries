/**
 * 
 */
package com.mystudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.StudentDao;
import com.mystudy.model.Student;

/**
 * @author om
 *
 */
@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public List<Student> findAllByTeamId(Long teamId){
		return studentDao.findAllByTeamId(teamId);
	}
}
