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
	
}
