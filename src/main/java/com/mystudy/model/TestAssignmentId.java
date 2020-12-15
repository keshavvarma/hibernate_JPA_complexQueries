/**
 * 
 */
package com.mystudy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.IdClass;

/**
 * @author om
 *
 */
@Embeddable
public class TestAssignmentId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "test_id")
	private long testId;
	@Column(name = "team_id")
	private long teamId;
	public TestAssignmentId() {
	}

	public TestAssignmentId(long testId, long teamId) {
		super();
		this.testId = testId;
		this.teamId = teamId;
	}

	public long getTestId() {
		return testId;
	}

	public long getTeamId() {
		return teamId;
	}
}
