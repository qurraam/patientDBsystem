package com.hospital.patient.assembler;

import org.springframework.stereotype.Service;

import com.hospital.patient.entity.Hospital;
import com.hospital.patient.pojo.HospitalDto;

@Service
public class HospitalAssembler {
	
	public Hospital assembleHospital(HospitalDto hospitalDto) {
		Hospital hospital = new Hospital();
		hospital.setId(hospitalDto.getId());
		hospital.setName(hospitalDto.getName());
		hospital.setAddress(hospitalDto.getAddress());
		hospital.setPhone(hospitalDto.getPhone());
		return hospital;

}
}
