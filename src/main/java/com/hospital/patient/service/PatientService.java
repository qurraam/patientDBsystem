package com.hospital.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.assembler.PatientAssembler;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.pojo.PatientDto;
import com.hospital.patient.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired 
	private PatientAssembler patientAssembler;
	@Autowired 
	private PatientRepository patientRepository;
	
	public PatientDto savePatient(PatientDto patientDto) {
		Patient patient = patientAssembler.assemblePatient(patientDto);
		patientRepository.save(patient);
		patientDto.setId(patient.getId());
		return patientDto;
	}
	public PatientDto updatePatient(PatientDto patientDto, long id) {
		patientDto.setId(id);
		Patient patient = patientAssembler.assemblePatient(patientDto);
		patientRepository.save(patient);
		return patientDto;
	}
	public List<Patient> getList() {
		return patientRepository.findAll();
	}
	public Optional<Patient> getPatientById(long id) {
		Patient patient = patientRepository.findOneById(id);
		
		return patientRepository.findById(id);
	}


     public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByNameContaining(name);
}

	public Boolean deletePatient(long id) {
		patientRepository.deleteById(id);
		return true;
		
	}

}
