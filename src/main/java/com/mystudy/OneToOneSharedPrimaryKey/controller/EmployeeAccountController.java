/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.controller;

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

import com.mystudy.OneToOneSharedPrimaryKey.model.Account;
import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;
import com.mystudy.OneToOneSharedPrimaryKey.service.EmployeeAccountService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/account")
public class EmployeeAccountController {
	@Autowired
	EmployeeAccountService employeeAccountService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> save(@RequestBody Account account, @RequestParam("employeeId") long employeeId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		account.setEmployee(employee);
		map.put("data", employeeAccountService.save(account));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findByEmployeedId.do")
	public Map<Object, Object> findAccountByEmployeeId(@RequestParam(name="employeeId") long employeeId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", employeeAccountService.getAccountByEmployeeId(employeeId));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findAll.do")
	public Map<Object, Object> findAll() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", employeeAccountService.findAll());
		return map;
	}
	
	@GetMapping(path = "/findByEmployeedId2.do")
	public ModelAndView findAccountByEmployeeId2(@RequestParam(name="employeeId") long employeeId) {
		/*Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", employeeAccountService.getAccountByEmployeeId(employeeId));*/
		return new ModelAndView("account", "account", employeeAccountService.getAccountByEmployeeId(employeeId));
	}
	
	@ResponseBody
	@GetMapping(path = "/findEmployeeAndAccountDetials.do")
	public Map<Object, Object> findEmployeeAndAccountDetials() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", employeeAccountService.findEmployeeAndAccountDetials());
		return map;
	}
}
