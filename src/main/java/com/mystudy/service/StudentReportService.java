/**
 * 
 */
package com.mystudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mystudy.dao.StudentAssessmentReportDao;
import com.mystudy.model.StudentReportView;

/**
 * @author om
 *
 */
@Service
public class StudentReportService {
	@Autowired
	StudentAssessmentReportDao studentAssessmentReportDao;
	
	@Transactional
	public List<StudentReportView> getStudentAssessment(long teamId, long testId) {
		return studentAssessmentReportDao.getStudentAssessmentDetailedReport(teamId, testId);
	}
}
