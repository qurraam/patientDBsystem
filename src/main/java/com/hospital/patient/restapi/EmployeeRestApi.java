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

import com.hospital.patient.entity.Employee;
import com.hospital.patient.pojo.EmployeeDto;
import com.hospital.patient.service.EmployeeService;

@RestController
public class EmployeeRestApi {
	@Autowired 
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.saveEmployee(employeeDto);
		return employeeDto;
	}
	@PutMapping("/employee/{id}")
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id) {
		employeeService.updateEmployee(employeeDto, id);
		return employeeDto;
	}
	@GetMapping("/employee")
	public List<Employee> getList() {
		return this.employeeService.getList();
	}
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
		return this.employeeService.getEmployeeById(id);
	}
	@DeleteMapping("/employee/{id}")
	public Boolean deleteEmployee(@PathVariable("id") long id) {
		//employeeRepository.deleteById(id);
		return this.employeeService.deleteEmployee(id);
	}

}
