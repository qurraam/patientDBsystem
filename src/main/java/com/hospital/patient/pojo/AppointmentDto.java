package com.hospital.patient.pojo;

import lombok.Data;

@Data
public class AppointmentDto {

	private Long id;
	private String pname;
	private String pphone;
    private String concern;
	private String description;
	private String dates;
	private HospitalDto hospital;
	private PatientDto patient;
	
}
