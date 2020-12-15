/**
 * 
 */
package com.mystudy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Keshav
 *
 */
@Entity(name="test_master")
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_id")
	private long testId;
	@Column(name="test_name")
	private String testName;
	@Column(name="callido_level")
	private long callidoLevel;
	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public long getCallidoLevel() {
		return callidoLevel;
	}
	public void setCallidoLevel(long callidoLevel) {
		this.callidoLevel = callidoLevel;
	}
}
