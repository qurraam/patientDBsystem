package com.hospital.patient.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.entity.Appointment;
import com.hospital.patient.pojo.AppointmentDto;
import com.hospital.patient.service.AppointmentService;

@RestController
public class AppointmentRestApi {
	@Autowired 
	private AppointmentService appointmentService;
	
	@PostMapping("/appointment")
	public AppointmentDto saveAppointment(@RequestBody AppointmentDto appointmentDto) {
		appointmentService.saveAppointment(appointmentDto);
		return appointmentDto;
	}
	@GetMapping("/appointment")
	public List<Appointment> getList() {
		return this.appointmentService.getList();
	}
	@GetMapping("/appointment/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable("id") long id) {
		return this.appointmentService.getAppointmentById(id);
	}
	@DeleteMapping("/appointment/{id}")
	public Boolean deleteAppointment(@PathVariable("id") long id) {
		//appointmentRepository.deleteById(id);
		return this.appointmentService.deleteAppointment(id);
	}


}