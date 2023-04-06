package com.hospital.patient.service;

import java.util.List;
import java.util.Optional;

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
	public HospitalDto updateHospital(HospitalDto hospitalDto, long id) {
		hospitalDto.setId(id);
		Hospital hospital = hospitalAssembler.assembleHospital(hospitalDto);
		hospitalRepository.save(hospital);
		return hospitalDto;
	}
	public List<Hospital> getList() {
		return hospitalRepository.findAll();
	}
	public Optional<Hospital> getHospitalById(long id) {
		Hospital hospital = hospitalRepository.findOneById(id);
		
		return hospitalRepository.findById(id);
	}
	public List<Hospital> getHospitalsByName(String name) {
        return hospitalRepository.findByNameContaining(name);
}

	public Boolean deleteHospital(long id) {
		hospitalRepository.deleteById(id);
		return true;
		
	}



}
