package com.hospital.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "reports")
@Data
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
    private String dates;
	private String patient_id;

	@Override
	public String toString() {
		return "Report [id=" + id + ", image=" + image + ", dates="
				+ dates+ "]";
	}

        }