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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mystudy.OneToOneUsingJoinTable.model.User;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="team_tagging_management")
public class TaggingManagement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tagging_management_id")
	private Long taggingManagementId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="team_id")
	private Team team;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties("vehicle")
	private User user;
	
	public Long getTaggingManagementId() {
		return taggingManagementId;
	}
	public void setTaggingManagementId(Long taggingManagementId) {
		this.taggingManagementId = taggingManagementId;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
