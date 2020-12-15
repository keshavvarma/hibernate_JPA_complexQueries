/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * @author om
 *
 */
public class StudentReportView {
	public StudentReportView() {
	}

	private long studentId;
	private String firstName;
	private String lastName;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime examStartDate;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime examEndDate;
	private long testId;
	private String testName;
	private long teamId;
	private int assessmentScore;
	private String teamCode;
	private String totalConsumedTime;
	private String testStatus;
	private List<QuestionReport> questionReports = new ArrayList<QuestionReport>();

	public LocalDateTime getExamStartDate() {
		return examStartDate;
	}

	public LocalDateTime getExamEndDate() {
		return examEndDate;
	}

	public long getTestId() {
		return testId;
	}

	public long getTeamId() {
		return teamId;
	}

	public int getAssessmentScore() {
		return assessmentScore;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public String getTotalConsumedTime() {
		return totalConsumedTime;
	}

	public void setExamStartDate(LocalDateTime examStartDate) {
		this.examStartDate = examStartDate;
	}

	public void setExamEndDate(LocalDateTime examEndDate) {
		this.examEndDate = examEndDate;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public void setAssessmentScore(int assessmentScore) {
		this.assessmentScore = assessmentScore;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public void setTotalConsumedTime(String totalConsumedTime) {
		this.totalConsumedTime = totalConsumedTime;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public long getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public List<QuestionReport> getQuestionReports() {
		return questionReports;
	}

	public void setQuestionReports(List<QuestionReport> questionReports) {
		this.questionReports = questionReports;
	}
}
