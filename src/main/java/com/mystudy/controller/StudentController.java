/**
 * 
 */
package com.mystudy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mystudy.model.Student;
import com.mystudy.model.StudentSupervisorView;
import com.mystudy.service.StudentService;
import com.mystudy.util.PagableImpl;

/**
 * @author Keshav
 *
 */

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	PagableImpl pagable;

	@ResponseBody
	@PostMapping(path = "/new.do")
	public Map<Object, Object> save(@RequestBody Student student) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", studentService.save(student));
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/getStudentAndSupervisor.do")
	public Map<Object, Object> fetchStudentAndSupervisor() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<StudentSupervisorView> list = studentService.fetchStudentAndSupervisor();
		System.out.println("size StudentSupervisorView list = " + list.size());
		map.put("data", list);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/save1000Records.do")
	public Map<Object, Object> save1000Records() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = studentService.save1000Records();
		map.put("data", status);
		return map;
	}
	
	@GetMapping(path = "/student.do")
	public ModelAndView studentPage() {
		return new ModelAndView("pagination");
	}
	
	@ResponseBody
	@GetMapping(path = "/findRecords.do")
	public Map<Object, Object> getRecords(@RequestParam("pageNumber") int pageNumber, HttpServletRequest req) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		System.out.println(req.getParameter("start"));
		System.out.println(pageNumber);
		/*Enumeration<String> names = req.getParameterNames();
		System.out.println("all paramters starts==================================");
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		System.out.println("all paramters end======================================");
		System.out.println(req.getParameter("iDisplayStart"));
		System.out.println(req.getParameter("iDisplayLength"));
		System.out.println(req.getParameter("sEcho"));
		
		List<Map<String, Object>> studentRecords = new ArrayList<Map<String, Object>>(); 
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("0", "Keshav V");
		maps.put("1", 20);
		maps.put("2", LocalDate.now());
		studentRecords.add(maps);
		map.put("aaData", studentRecords);*/
		/*
		Student s = new Student();
		s.setName("Keshav V");
		s.setAge(20);
		s.setDob(LocalDate.now());
		List<Student> studentRecords = new ArrayList<Student>(); 
		studentRecords.add(s);
		*/
		map.put("draw", req.getParameter("draw") == null ? 0 : Integer.parseInt(req.getParameter("draw")));
		List<Student> studentRecords2 = studentService.findRecords(pageNumber, 10, pagable);
		map.put("recordsTotal", 500);
		map.put("recordsFiltered", 10);
		map.put("aaData", studentRecords2);
		map.put("pagable", pagable);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findRecordsWithPageable1.do")
	public Map<Object, Object> findRecordsWithPageable1(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws Exception {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "studentId"));
		
		
		Page<Student> page = studentService.findWithPageable1(pageable);
		//List<Student> page = studentService.findWithPageable1(PageRequest.of(pageNumber, pageSize));
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		//map.put("data", page);
		map.put("totalRecords", page.getTotalElements());
		map.put("totalFetchedRecords", page.getNumberOfElements());
		map.put("totalPages", page.getTotalPages());
		map.put("hasNext", page.hasNext());
		map.put("hasPrevious", page.hasPrevious());
		map.put("data", page.getContent());
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/findRecordsWithCriteria.do")
	public Map<Object, Object> findRecordsWithCriteria() throws Exception {
		List<Student> students = studentService.findRecordsWithCriteria();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", students);
		return map;
	}
	
	@ResponseBody
	@GetMapping(path = "/queryByMethodName.do")
	public Map<Object, Object> queryByMethodName() throws Exception {
		List<Student> students = studentService.queryByMethodName();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("data", students);
		return map;
	}
	
}
