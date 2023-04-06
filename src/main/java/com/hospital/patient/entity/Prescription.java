package com.hospital.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "prescriptions")
@Data
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
    private String dates;
	//private String patient_id;
	//private String appointment_id;
	

    @ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;
    
    @ManyToOne
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointment;
	
	
	
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", image=" + image + ", dates=" 
	            + dates + "]";
	}
	
       
	
        }

