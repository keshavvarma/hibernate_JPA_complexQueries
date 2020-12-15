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

import com.mystudy.service.TaggingManagementService;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/tagging")
public class TaggingMnagementController {
	@Autowired
	TaggingManagementService taggingmanagementervice;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> tagTeam(@RequestBody Map<String, String> reqMap) {
		long teamId = Long.parseLong(reqMap.get("teamId"));
		long userId = Long.parseLong(reqMap.get("userId"));
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", taggingmanagementervice.tagTeam(teamId, userId));
		return map;
	}
}
