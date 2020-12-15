/**
 * 
 */
package com.mystudy.ManyToManyMapping.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mystudy.ManyToManyMapping.model.Book;
import com.mystudy.ManyToManyMapping.service.BookService;

/**
 * @author Keshav
 *
 */
@Controller
@RequestMapping(path="book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@ResponseBody
	@PostMapping(path="new.do")
	public Map<Object, Object> save(@RequestBody @Valid Book book){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", bookService.save(book));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="find.do")
	public Map<Object, Object> find(@RequestParam(name="bookId") long bookId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("post", bookService.find(bookId));
		return map;
	}
	
	@ResponseBody
	@PutMapping(path="update.do")
	public Map<Object, Object> update(@RequestBody Book book){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("book", bookService.update(book));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="findAll.do", produces="application/json")
	public Map<Object, Object> findAll(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("books", bookService.findAll());
		return map;
	}
	
	@ResponseBody
	@GetMapping(path="findAllOnJsp.do")
	public ModelAndView findAllOnJsp(ModelMap map){
		map.put("books", bookService.findAll());
		return new ModelAndView("book");
	}
}
