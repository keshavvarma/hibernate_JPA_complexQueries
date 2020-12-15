/**
 * 
 */
package com.mystudy.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystudy.model.Test;
import com.mystudy.service.TestService;

/**
 * @author om
 *
 */
@RestController
@RequestMapping("/tests")
public class TestController {
	@Autowired
	TestService testService;

	@GetMapping
	public Map<String, Object> findAll(){
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		List<Test> tests = testService.findAllTests();
		resp.put("count", tests.size());
		resp.put("data", tests);
		return resp;
	}
	
}
