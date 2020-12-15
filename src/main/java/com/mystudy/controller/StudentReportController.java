/**
 * 
 */
package com.mystudy.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mystudy.model.StudentReportView;
import com.mystudy.service.StudentReportService;
import com.mystudy.util.StudentAssessmentReport;

/**
 * @author om
 *
 */
@RestController
@RequestMapping("/reports")
public class StudentReportController {
	@Autowired
	StudentReportService studentReportService;

	@GetMapping("/getAdaptiveDetailedReport")
	public Map<String, Object> findAll(@RequestParam long teamId, @RequestParam long testId) {
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		List<StudentReportView> reports = studentReportService.getStudentAssessment(teamId, testId);
		resp.put("count", reports.size());
		resp.put("data", reports);
		return resp;
	}

	@GetMapping("/downloadSampleExcel")
	public ModelAndView downloadSampleExcel() {
		return new ModelAndView(new StudentAssessmentReport());
	}
}
