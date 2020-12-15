/**
 * 
 */
package com.mystudy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.model.Test;
import com.mystudy.service.TestService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/")
public class WelcomeController {
	@ResponseBody
	@GetMapping(path = "/welcome.do")
	public Map<Object, Object> welcome() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", "welocme");
		return map;
	}
}
