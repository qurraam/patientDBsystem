package com.hospital.patient.assembler;

import org.springframework.stereotype.Service;

import com.hospital.patient.entity.Employee;
import com.hospital.patient.entity.Hospital;
import com.hospital.patient.pojo.EmployeeDto;

@Service
public class EmployeeAssembler {
	
	public Employee assembleEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setAddress(employeeDto.getAddress());
		employee.setPhone(employeeDto.getPhone());
		employee.setEmail(employeeDto.getEmail());
		employee.setRole(employeeDto.getRole());
		employee.setLicense_number(employeeDto.getLicense_number());
		Hospital hospital = new Hospital();
		hospital.setId(employeeDto.getHospital().getId());
		employee.setHospital(hospital);
		
		return employee;

}	

}
