/**
 * 
 */
package com.mystudy.OneToManyMapping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mystudy.OneToManyMapping.model.Comment;
import com.mystudy.OneToManyMapping.model.Post;
import com.mystudy.OneToManyMapping.service.CommentService;

/**
 * @author Keshav
 *
 */
@Controller
//@Transactional(propagation = Propagation.REQUIRES_NEW)
@RequestMapping(path="comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody Comment comment, @RequestParam long postId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("success", false);
		try {
			Post post = new Post();
			post.setPostId(postId);
			comment.setPost(post);
			map.put("success", true);
			map.put("commentId", commentService.save(comment).getCommentId());
		} catch (Exception e) {
			map.put("error", "Post details not exist for provided id");
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping(path="saveAll.do")
	public Map<Object, Object> saveAll(@RequestBody List<Comment> comments, @RequestParam(name="postId") long postId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		comments.add(new Comment());
		try {
			map.put("comments", commentService.saveAll(comments, postId));
		} catch (Exception e) {
			System.out.println("Exception name = " + e.getClass());
			System.out.println("Description = " + e);
			map.put("comments", "comments not added");
		}
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="commentId") long commentId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("comment", commentService.find(commentId));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="findByPostId.do")
	public Map<Object, Object> findCommentsByPostId(@RequestParam(name="postId") long postId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("comments", commentService.findCommentsByPostId(postId));
		return map;
	}
	
}
