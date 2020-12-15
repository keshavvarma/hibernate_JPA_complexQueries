/**
 * 
 */
package com.mystudy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="school_student")
public class Student extends TableOperation{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private long studentId;
	@Column(name="first_name") 
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="parent_email_id")
	private String parentEmailId;
	@Column(name="password")
	private String password;
	@Column(name="school_group_id")
	private Long schoolGroupId;
	@Column(name="school_id")
	private Long schoolId;
	@Column(name="profile_picture")
	private String profilePicture;
	@Column(name="curriculum")
	private String curriculum;
	@Column(name="callido_level")
	private Integer callido_level;
	@Column(name="grade")
	private String grade;
	@Column(name="division_id")
	private Integer divisionId;
	@Column(name="package_id")
	private Integer packageId;
	@Column(name="academic_year")
	private String academicYear;
	@Column(name="litmus_id")
	private Integer litmusId;
	@Column(name="status")
	private boolean status;
	@Column(name="token_Id")
	private String tokenId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id")
	private Team team;
	
	public Student() {
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentEmailId() {
		return parentEmailId;
	}

	public void setParentEmailId(String parentEmailId) {
		this.parentEmailId = parentEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSchoolGroupId() {
		return schoolGroupId;
	}

	public void setSchoolGroupId(Long schoolGroupId) {
		this.schoolGroupId = schoolGroupId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public Integer getCallido_level() {
		return callido_level;
	}

	public void setCallido_level(Integer callido_level) {
		this.callido_level = callido_level;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public Integer getLitmusId() {
		return litmusId;
	}

	public void setLitmusId(Integer litmusId) {
		this.litmusId = litmusId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
