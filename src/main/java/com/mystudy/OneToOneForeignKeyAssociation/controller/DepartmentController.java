/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.OneToOneForeignKeyAssociation.model.Department;
import com.mystudy.OneToOneForeignKeyAssociation.service.DepartmentService;

/**
 * @author Keshav
 *
 */
@Controller
@RequestMapping(path="department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody Department department){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("department", departmentService.save(department));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="departmentId") long departmentId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("department", departmentService.find(departmentId));
		return map;
	}
	
	@ResponseBody
	@PostMapping(path="updateHead.do", consumes="application/json")
	public Map<Object, Object> updateDepartmentHeadWithJsonRequest(@RequestBody Map<String, String> reqMap){
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			long departmentId = Long.parseLong(reqMap.get("departmentId"));
			long staffId = Long.parseLong(reqMap.get("staffId"));
			map.put("department", departmentService.updateDepartmentHead(departmentId, staffId));
		} catch (Exception e) {
			map.put("message", "Exception occured while retrieving data");
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping(path="updateHead.do")
	public Map<Object, Object> updateDepartmentHead(HttpServletRequest req){
		Map<Object, Object> map = new HashMap<Object, Object>();
		long departmentId = Long.parseLong(req.getParameter("departmentId"));
		long staffId = Long.parseLong(req.getParameter("staffId"));
		map.put("department", departmentService.updateDepartmentHead(departmentId, staffId));
		return map;
	}
	
}
