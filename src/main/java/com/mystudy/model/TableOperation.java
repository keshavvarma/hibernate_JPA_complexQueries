/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mystudy.formatter.CustomLocalDateTimeSerializer;

/**
 * @author Keshav
 *
 */
@MappedSuperclass
public class TableOperation {
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	//@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="created_on", nullable=true)
	private LocalDateTime createdOn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="updated_on", nullable=true)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime updatedOn;
	@Column(name="deleted_on", nullable=true)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime deletedOn;
	@Column(name="created_by", nullable=true)
	private Long createdBy;
	@Column(name="updated_by", nullable=true)
	private Long updatedBy;
	@Column(name="deleted_by", nullable=true)
	private Long deletedBy;
	
	@PrePersist
	void onPersist() {
		this.createdOn = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedOn = LocalDateTime.now();
	}
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}
	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Long getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}
}
