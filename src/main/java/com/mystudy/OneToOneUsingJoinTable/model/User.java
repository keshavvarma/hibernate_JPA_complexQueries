/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="user_master")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
    private Long userId;
	@Column(name="user_name")
	private String userName;
	//@JsonBackReference
	@JsonIgnoreProperties("user")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinTable(name="user_vehicle_master",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
		inverseJoinColumns = {@JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")}
			)
	private Vehicle vehicle;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
