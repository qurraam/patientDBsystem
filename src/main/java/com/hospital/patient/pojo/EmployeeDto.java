package com.hospital.patient.pojo;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String role;
	private String license_number;
	private HospitalDto hospital;

}
