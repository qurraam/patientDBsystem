package com.hospital.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.assembler.AppointmentAssembler;
import com.hospital.patient.entity.Appointment;
import com.hospital.patient.pojo.AppointmentDto;
import com.hospital.patient.repository.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired 
	private AppointmentAssembler appointmentAssembler;
	@Autowired 
	private AppointmentRepository appointmentRepository;
	
	public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = appointmentAssembler.assembleAppointment(appointmentDto);
		appointmentRepository.save(appointment);
		appointmentDto.setId(appointment.getId());
		return appointmentDto;
	}


public List<Appointment> getList() {
		return appointmentRepository.findAll();
	}
	public Optional<Appointment> getAppointmentById(long id) {
		Appointment appointment = appointmentRepository.findOneById(id);
		
		return appointmentRepository.findById(id);
	}

	public Boolean deleteAppointment(long id) {
		appointmentRepository.deleteById(id);
		return true;
		
	}

}