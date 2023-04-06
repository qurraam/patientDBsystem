package com.hospital.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.assembler.EmployeeAssembler;
import com.hospital.patient.entity.Employee;
import com.hospital.patient.pojo.EmployeeDto;
import com.hospital.patient.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired 
	private EmployeeAssembler employeeAssembler;
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = employeeAssembler.assembleEmployee(employeeDto);
		employeeRepository.save(employee);
		employeeDto.setId(employee.getId());
		return employeeDto;
	}
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {
		employeeDto.setId(id);
		Employee employee = employeeAssembler.assembleEmployee(employeeDto);
		employeeRepository.save(employee);
		return employeeDto;
	}
	public List<Employee> getList() {
		return employeeRepository.findAll();
	}
	public List<Employee> getEmployeesByHospital(Long hospitalId) {
        return employeeRepository.findByHospitalId(hospitalId);
    }
	public Optional<Employee> getEmployeeById(long id) {
		Employee employee = employeeRepository.findOneById(id);
		
		return employeeRepository.findById(id);
	}
	public Boolean deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return true;
		
	}

}
