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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="vehicle_master")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_id")
    private Long vehicleId;
	@Column(name="vehicle_type")
	private String vehicleType;
	@Column(name="vehicle_number")
	private String vehicleNumber;
	//@JsonManagedReference
	@JsonIgnoreProperties("vehicle")
	@OneToOne(mappedBy="vehicle", fetch=FetchType.LAZY)
	private User user;
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
