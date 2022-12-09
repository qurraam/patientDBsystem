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

import com.hospital.patient.entity.Patient;
import com.hospital.patient.pojo.PatientDto;
import com.hospital.patient.service.PatientService;

@RestController
public class PatientRestApi {
	@Autowired 
	private PatientService patientService;
	@PostMapping("/patient")
	public PatientDto savePatient(@RequestBody PatientDto patientDto) {
		patientService.savePatient(patientDto);
		return patientDto;
	}
	@PutMapping("/patient/{id}")
	public PatientDto updatePatient(@RequestBody PatientDto patientDto, @PathVariable("id") long id) {
		patientService.updatePatient(patientDto, id);
		return patientDto;
	}
	@GetMapping("/patient")
	public List<Patient> getList() {
		return this.patientService.getList();
	}
	@GetMapping("/patient/{id}")
	public Optional<Patient> getPatientById(@PathVariable("id") long id) {
		return this.patientService.getPatientById(id);
	}
	@DeleteMapping("/patient/{id}")
	public Boolean deletePatient(@PathVariable("id") long id) {
		//patientRepository.deleteById(id);
		return this.patientService.deletePatient(id);
	}

}
