package com.hospital.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String pname;
	private String pphone;
	private String description;
	private String dates;
	private String concern;
	
	
	
	

    @ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
    
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
}
