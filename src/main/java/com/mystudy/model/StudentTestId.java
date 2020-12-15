/**
 * 
 */
package com.mystudy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author om
 *
 */
@Embeddable
public class StudentTestId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "student_id")
	private Long studentId;
	@Column(name = "test_id")
	private Long testId;

	public StudentTestId() {
	}

	public StudentTestId(Long studentId, Long testId) {
		super();
		this.studentId = studentId;
		this.testId = testId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public Long getTestId() {
		return testId;
	}
}
