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
@Entity(name="team_master")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="team_id")
	private long teamId;
	@Column(name="team_code")
	private String teamCode;
	@Column(name="sgl_id")
	private Integer sglId;
	@Column(name="division_id")
	private Integer divisionId;
	@Column(name="package_id")
	private Integer packageId;
	@Column(name="accademic_year")
	private String accademicYear;
	@Column(name="litmus_id")
	private String litmusId;
	
	public Team() {
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public Integer getSglId() {
		return sglId;
	}

	public void setSglId(Integer sglId) {
		this.sglId = sglId;
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

	public String getAccademicYear() {
		return accademicYear;
	}

	public void setAccademicYear(String accademicYear) {
		this.accademicYear = accademicYear;
	}

	public String getLitmusId() {
		return litmusId;
	}

	public void setLitmusId(String litmusId) {
		this.litmusId = litmusId;
	}
}
