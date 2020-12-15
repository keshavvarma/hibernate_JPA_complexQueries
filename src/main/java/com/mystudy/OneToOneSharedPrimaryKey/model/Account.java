/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="account_master")
public class Account {
	@Id
    private Long employeeId;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name="employee_id")
	private Employee employee;
	@Column(name="account_number")
	private String accountNumber;
	@Column(name="bank_name")
	private String bankName;
	
	//@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
