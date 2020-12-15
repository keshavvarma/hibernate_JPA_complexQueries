/**
 * 
 */
package com.mystudy.OneToManyMapping.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.OneToManyMapping.model.Comment;
import com.mystudy.OneToManyMapping.model.Post;
import com.mystudy.OneToManyMapping.service.PostService;

/**
 * @author Keshav
 *
 */
@Controller
@RequestMapping(path="post")
public class PostController {
	@Autowired
	PostService postService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody Post post){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", postService.save(post));
		return map;
	}
	
	@ResponseBody
	@PostMapping(path="newWithCommnets.do")
	public Map<Object, Object> savePostWithComments(@RequestBody @Valid Post post){
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			map.put("post", postService.save(post));
		} catch(Exception e) {
			System.out.println(e);
			map.put("message", "Post not added");
		}
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="postId") long postId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", postService.find(postId));
		return map;
	}
}
