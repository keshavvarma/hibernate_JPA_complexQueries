/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.OneToOneUsingJoinTable.service.UserService;

/**
 * @author Keshav
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> save(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", userService.save(user));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/find.do")
	public Map<Object, Object> find(@RequestParam(name="userId") long userId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		User user = userService.find(userId);
		System.out.println(user);
		map.put("data", user);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findUserAndVehicle.do")
	public Map<Object, Object> findUserAndVehicleByUserId(@RequestParam(name="userId") long userId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		User user = userService.findUserAndVehicleByUserId(userId);
		System.out.println(user);
		map.put("data", user);
		return map;
	}
	
	@GetMapping(path = "/findWithMvc.do")
	public ModelAndView findWithMvc(@RequestParam(name="userId") long userId) {
		User user = userService.find(userId);
		System.out.println(user);
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("data", user);
		return mv;
	}
}
