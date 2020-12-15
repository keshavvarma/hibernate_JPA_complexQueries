/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author om
 *
 */
@Entity
@Table(name = "student_test")
public class StudentTest extends TableOperation {
	public StudentTest() {
	}

	@EmbeddedId
	private StudentTestId studentTestId;
	@Column(name = "exam_start_time")
	private LocalDateTime examStartTime;
	@Column(name = "exam_end_time")
	private LocalDateTime examEndTime;
	@Column(name = "allotted_time")
	private Long allottedTime;
	@Column(name = "consumed_time")
	private Long consumedTime;
	@Column(name = "score")
	private int score;
	@Column(name = "test_status")
	private String testStatus;
	@Column(name = "reportURL")
	private String reportURL;

	public StudentTestId getStudentTestId() {
		return studentTestId;
	}

	public LocalDateTime getExamStartTime() {
		return examStartTime;
	}

	public LocalDateTime getExamEndTime() {
		return examEndTime;
	}

	public Long getAllottedTime() {
		return allottedTime;
	}

	public Long getConsumedTime() {
		return consumedTime;
	}

	public int getScore() {
		return score;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public String getReportURL() {
		return reportURL;
	}

	public void setStudentTestId(StudentTestId studentTestId) {
		this.studentTestId = studentTestId;
	}

	public void setExamStartTime(LocalDateTime examStartTime) {
		this.examStartTime = examStartTime;
	}

	public void setExamEndTime(LocalDateTime examEndTime) {
		this.examEndTime = examEndTime;
	}

	public void setAllottedTime(Long allottedTime) {
		this.allottedTime = allottedTime;
	}

	public void setConsumedTime(Long consumedTime) {
		this.consumedTime = consumedTime;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public void setReportURL(String reportURL) {
		this.reportURL = reportURL;
	}
}
