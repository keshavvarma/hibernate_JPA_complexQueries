/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.OneToOneForeignKeyAssociation.model.Staff;
import com.mystudy.OneToOneForeignKeyAssociation.service.StaffService;

/**
 * @author Keshav
 *
 */
@Controller
@RequestMapping(path="staff")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody Staff staff){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("staff", staffService.save(staff));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="staffId") long staffId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("staff", staffService.find(staffId));
		return map;
	}
	
}
