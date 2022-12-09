package com.hospital.patient.pojo;

import lombok.Data;

@Data
public class PatientDto {
	private Long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String age;
	private String gender;
	private String medical_summary;
	private String contact_person_name;
	private String contact_person_phone;
	private HospitalDto hospital;


}
