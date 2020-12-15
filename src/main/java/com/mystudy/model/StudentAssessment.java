/**
 * 
 */
package com.mystudy.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author om
 *
 */
@Entity
@Table(name = "student_assessment")
public class StudentAssessment extends TableOperation {
	public StudentAssessment() {
	}

	@EmbeddedId
	private StudentTestId studentTestId;
	@Column(name = "question_id")
	private int questionId;
	@Column(name = "score")
	private int score;
	@Column(name = "question_response_time")
	private Long questionResponseTime;

	public StudentTestId getStudentTestId() {
		return studentTestId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public int getScore() {
		return score;
	}

	public Long getQuestionResponseTime() {
		return questionResponseTime;
	}

	public void setStudentTestId(StudentTestId studentTestId) {
		this.studentTestId = studentTestId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setQuestionResponseTime(Long questionResponseTime) {
		this.questionResponseTime = questionResponseTime;
	}
}
