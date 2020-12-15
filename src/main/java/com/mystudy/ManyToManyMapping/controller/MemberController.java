/**
 * 
 */
package com.mystudy.ManyToManyMapping.controller;

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

import com.mystudy.ManyToManyMapping.model.LibraryMember;
import com.mystudy.ManyToManyMapping.service.LibraryMemberService;

/**
 * @author Keshav
 *
 */
@Controller
@RequestMapping(path="member")
public class MemberController {
	@Autowired
	LibraryMemberService libraryMemberService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody LibraryMember libraryMember){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", libraryMemberService.save(libraryMember));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="memberId") long memberId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", libraryMemberService.find(memberId));
		return map;
	}
	
	@ResponseBody
	@PostMapping(path="issueBook.do")
	public Map<Object, Object> issueBook(@RequestBody Map<String, String> reqData){
		int memberId = Integer.parseInt(reqData.get("memberId"));
		int bookId = Integer.parseInt(reqData.get("bookId"));
		Map<Object, Object> map = new HashMap<Object, Object>();
		System.out.println(libraryMemberService.issueBook(memberId, bookId));
		map.put("post", "Book isued successfully");
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="findAll.do")
	public Map<Object, Object> findAll(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("books", libraryMemberService.findAll());
		return map;
	}
}
