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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mystudy.model.Student;
import com.mystudy.service.StudentService;

/**
 * @author om
 *
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	StudentService studentService;
	
	@GetMapping
	@ResponseBody
	public String test(){
		return "Working";
	}
	
	@GetMapping("/getAllByTeamId/{teamId}")
	public Map<String, Object> findAllByTeamId(@PathVariable Long teamId){
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		List<Student> students = studentService.findAllByTeamId(teamId);
		resp.put("count", students.size());
		resp.put("data", students);
		return resp;
	}
	
	
	
}
