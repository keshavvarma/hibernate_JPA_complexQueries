/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;
import com.mystudy.OneToOneSharedPrimaryKey.service.EmployeeService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> save(@RequestBody Employee employee) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", employeeService.save(employee));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findAllEmployeeWithAccountDetails.do")
	public Map<Object, Object> findAllEmployeeWithAccountDetails() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Employee> employeeListWithAccountDetails = new ArrayList<Employee>();
		employeeListWithAccountDetails = employeeService.findAllEmployeeWithAccountDetails();
		map.put("data", employeeListWithAccountDetails);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findAll.do")
	public Map<Object, Object> findAll() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Employee> employeeListWithAccountDetails = new ArrayList<Employee>();
		employeeListWithAccountDetails = employeeService.findAllEmployeeWithAccountDetails();
		map.put("data", employeeListWithAccountDetails);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/find.do")
	public Map<Object, Object> find(@RequestParam(name="employeeId") long employeeId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Employee> employeeListWithAccountDetails = new ArrayList<Employee>();
		map.put("data", employeeService.find(employeeId));
		return map;
	}
	
}
