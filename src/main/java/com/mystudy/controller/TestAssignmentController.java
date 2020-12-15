/**
 * 
 */
package com.mystudy.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystudy.model.TestAssignment;
import com.mystudy.service.TestAssignmentService;

/**
 * @author om
 *
 */
@RestController
@RequestMapping("/testAssignments")
public class TestAssignmentController {
	@Autowired
	TestAssignmentService testAssignmentService;

	@GetMapping("/findAllByAssignedTestByTeamId/{teamId}")
	public Map<String, Object> findAllByTeamId(@PathVariable Long teamId){
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		List<TestAssignment> assignedTests = testAssignmentService.findAllByAssignedTestByTeamId(teamId);
		resp.put("count", assignedTests.size());
		resp.put("data", assignedTests);
		return resp;
	}
	
}
