package com.hospital.patient.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.pojo.HospitalDto;
import com.hospital.patient.service.HospitalService;

@RestController
public class HospitalRestApi {
	
	@Autowired 
	private HospitalService hospitalService;
	
	@PostMapping("/hospital")
	public HospitalDto saveHospital(@RequestBody HospitalDto hospitalDto) {
		hospitalService.saveHospital(hospitalDto);
		return hospitalDto;
	}
	

}
