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
@Table(name = "student_answer")
public class StudentAnswer extends TableOperation {
	public StudentAnswer() {
	}

	@EmbeddedId
	private StudentTestId studentTestId;
	@Column(name = "question_id")
	private int questionId;
	@Column(name = "media_id")
	private int mediaId;
	@Column(name = "option_id")
	private Long optionId;

	public StudentTestId getStudentTestId() {
		return studentTestId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setStudentTestId(StudentTestId studentTestId) {
		this.studentTestId = studentTestId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
}
