package com.hospital.patient.assembler;

import org.springframework.stereotype.Service;

import com.hospital.patient.entity.Hospital;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.pojo.PatientDto;

@Service
public class PatientAssembler {
	public Patient assemblePatient(PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setId(patientDto.getId());
		patient.setName(patientDto.getName());
		patient.setAddress(patientDto.getAddress());
		patient.setPhone(patientDto.getPhone());
		patient.setEmail(patientDto.getEmail());
		patient.setAge(patientDto.getAge());
		patient.setGender(patientDto.getGender());
        patient.setMedical_summary(patientDto.getMedical_summary());
        patient.setContact_person_name(patientDto.getContact_person_name());
        patient.setContact_person_phone(patientDto.getContact_person_phone());
		Hospital hospital = new Hospital();
		hospital.setId(patientDto.getHospital().getId());
		patient.setHospital(hospital);
		
		return patient;

}
}
