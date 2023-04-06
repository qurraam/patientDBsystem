package com.hospital.patient.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.entity.Hospital;
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
	
	@PutMapping("/hospital/{id}")
	public HospitalDto updateHospital(@RequestBody HospitalDto hospitalDto, @PathVariable("id") long id) {
		hospitalService.updateHospital(hospitalDto, id);
		return hospitalDto;
	}
	@GetMapping("/hospital")
	public List<Hospital> getList() {
		return this.hospitalService.getList();
	}
	@GetMapping("/hospital/{id}")
	public Optional<Hospital> getHospitalById(@PathVariable("id") long id) {
		return this.hospitalService.getHospitalById(id);
	}
	@GetMapping("/hospital/name/{name}")
	public List<Hospital> getHospitalsByName(@PathVariable("name") String name) {
	    return this.hospitalService.getHospitalsByName(name);
	}
	@DeleteMapping("{id}")
	public Boolean deleteHospital(@PathVariable("id") long id) {
		//hospitalRepository.deleteById(id);
		return this.hospitalService.deleteHospital(id);
	}
	

}
