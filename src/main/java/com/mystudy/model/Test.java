/**
 * 
 */
package com.mystudy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="test_master")
public class Test extends TableOperation{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_id")
	private long testId;
	@Column(name="test_name")
	private String testName;
	@Column(name="test_type")
	private String testType;
	@Column(name="test_phase")
	private String testPhase;
	@Column(name="callido_level")
	private long callidoLevel;
	@Column(name="status")
	private boolean status;
	public Test() {
		
	}
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
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestPhase() {
		return testPhase;
	}
	public void setTestPhase(String testPhase) {
		this.testPhase = testPhase;
	}
	public long getCallidoLevel() {
		return callidoLevel;
	}
	public void setCallidoLevel(long callidoLevel) {
		this.callidoLevel = callidoLevel;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
