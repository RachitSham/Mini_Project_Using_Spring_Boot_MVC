package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Table(name = "JPA_ACTOR_INFO")
@Data
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;

	@Column(name = "Actor_name", length = 30)
	private String aname;

	@Column(name = "Address", length = 40)
	private String addrs;

	private String category;

	private Float fees;

	// Meta Data Columns
	
	// for Versioning Feature
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer UpdateCount;

	// For time stamping Feature
	@Column(name = "CREATE_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createDate;

	// For time stamping Features
	@Column(name="UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	@Column(length = 20, updatable = false)
	private String createdBy;
	
	@Column(length = 20, insertable = false)
	private String updatedBy;
}
