/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;
import com.mystudy.OneToOneUsingJoinTable.service.VehicleService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> save(@RequestBody Vehicle vehicle) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", vehicleService.save(vehicle));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/find.do")
	public Map<Object, Object> find(@RequestParam(name="vehicleId") long vehicleId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Vehicle vehicle = vehicleService.find(vehicleId);
		System.out.println(vehicle);
		map.put("data", vehicle);
		return map;
	}
	
	@GetMapping(path = "/findWithMvc.do")
	public ModelAndView findWithMvc(@RequestParam(name="vehicleId") long vehicleId) {
		Vehicle vehicle = vehicleService.find(vehicleId);
		System.out.println(vehicle);
		ModelAndView mv = new ModelAndView("vehicle");
		mv.addObject("data", vehicle);
		return mv;
	}
}
