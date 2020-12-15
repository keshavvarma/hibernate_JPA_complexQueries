/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name = "test_assignment")
@Embeddable
public class TestAssignment extends TableOperation {
	public TestAssignment() {
	}
	@EmbeddedId
	private TestAssignmentId testAssignmentId;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "start_date")
	private LocalDateTime startDate;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "end_date")
	private LocalDateTime endDate;
	@Column(name = "display_test_name")
	private String displayTestName;
	@Column(name = "allotted_time")
	private Long allottedTime;
	@Column(name = "grace_period")
	private int gracePeriod;
	@Column(name = "before_7_days")
	private String before7Days;
	@Column(name = "before_5_days")
	private String before5Days;
	@Column(name = "before_2_days")
	private String before2Days;
	@Column(name = "day_zero")
	private String dayZero;
	@Column(name = "after_1_day")
	private String after1Day;
	@Column(name = "after_3_days")
	private String after3Day;
	@Column(name = "after_7_days")
	private String after7Day;
	@Column(name = "after_14_days")
	private String after14Day;
	@Column(name = "after_30_days")
	private String after30Day;
	@Column(name = "test_release_status")
	private String testReleaseStatus;
	@Column(name = "test_release_condition")
	private String testReleaseCondition;

	public TestAssignmentId getTestAssignmentId() {
		return testAssignmentId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public String getDisplayTestName() {
		return displayTestName;
	}

	public Long getAllottedTime() {
		return allottedTime;
	}

	public int getGracePeriod() {
		return gracePeriod;
	}

	public String getBefore7Days() {
		return before7Days;
	}

	public String getBefore5Days() {
		return before5Days;
	}

	public String getBefore2Days() {
		return before2Days;
	}

	public String getDayZero() {
		return dayZero;
	}

	public String getAfter1Day() {
		return after1Day;
	}

	public String getAfter3Day() {
		return after3Day;
	}

	public String getAfter7Day() {
		return after7Day;
	}

	public String getAfter14Day() {
		return after14Day;
	}

	public String getAfter30Day() {
		return after30Day;
	}

	public String getTestReleaseStatus() {
		return testReleaseStatus;
	}

	public String getTestReleaseCondition() {
		return testReleaseCondition;
	}

	public void setTestAssignmentId(TestAssignmentId testAssignmentId) {
		this.testAssignmentId = testAssignmentId;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setDisplayTestName(String displayTestName) {
		this.displayTestName = displayTestName;
	}

	public void setAllottedTime(Long allottedTime) {
		this.allottedTime = allottedTime;
	}

	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public void setBefore7Days(String before7Days) {
		this.before7Days = before7Days;
	}

	public void setBefore5Days(String before5Days) {
		this.before5Days = before5Days;
	}

	public void setBefore2Days(String before2Days) {
		this.before2Days = before2Days;
	}

	public void setDayZero(String dayZero) {
		this.dayZero = dayZero;
	}

	public void setAfter1Day(String after1Day) {
		this.after1Day = after1Day;
	}

	public void setAfter3Day(String after3Day) {
		this.after3Day = after3Day;
	}

	public void setAfter7Day(String after7Day) {
		this.after7Day = after7Day;
	}

	public void setAfter14Day(String after14Day) {
		this.after14Day = after14Day;
	}

	public void setAfter30Day(String after30Day) {
		this.after30Day = after30Day;
	}

	public void setTestReleaseStatus(String testReleaseStatus) {
		this.testReleaseStatus = testReleaseStatus;
	}

	public void setTestReleaseCondition(String testReleaseCondition) {
		this.testReleaseCondition = testReleaseCondition;
	}
}
