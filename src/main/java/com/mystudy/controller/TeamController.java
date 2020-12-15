/**
 * 
 */
package com.mystudy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.model.Team;
import com.mystudy.service.TeamService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	TeamService teamService;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> saveTest(@RequestBody Team team) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Team team2 = teamService.saveTeam(team);
		map.put("data", team2);
		return map;
	}
}
