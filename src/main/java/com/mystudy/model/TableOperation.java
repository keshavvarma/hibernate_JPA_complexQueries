/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="created_date", nullable=true)
	private LocalDateTime createdDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="updated_date", nullable=true)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime updatedDate;
	@Column(name="deleted_date", nullable=true)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime deletedDate;
	@Column(name="created_by", nullable=true)
	private Long createdBy;
	@Column(name="updated_by", nullable=true)
	private Long updatedBy;
	@Column(name="deleted_by", nullable=true)
	private Long deletedBy;
	
	@PrePersist
	void onPersist() {
		this.createdDate = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedDate = LocalDateTime.now();
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDateTime getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(LocalDateTime deletedDate) {
		this.deletedDate = deletedDate;
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
