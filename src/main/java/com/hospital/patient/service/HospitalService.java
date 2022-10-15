package com.hospital.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.assembler.HospitalAssembler;
import com.hospital.patient.entity.Hospital;
import com.hospital.patient.pojo.HospitalDto;
import com.hospital.patient.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private HospitalAssembler hospitalAssembler;
	
	public HospitalDto saveHospital(HospitalDto hospitalDto) {
		Hospital hospital = hospitalAssembler.assembleHospital(hospitalDto);
		hospitalRepository.save(hospital);
		hospitalDto.setId(hospital.getId());
		return hospitalDto;
	}
	


}
