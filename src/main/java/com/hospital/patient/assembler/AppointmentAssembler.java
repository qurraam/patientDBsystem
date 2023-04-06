package com.hospital.patient.assembler;

import org.springframework.stereotype.Service;

import com.hospital.patient.entity.Appointment;
import com.hospital.patient.entity.Hospital;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.pojo.AppointmentDto;

@Service
public class AppointmentAssembler {
	
	public Appointment assembleAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = new Appointment();
		appointment.setId(appointmentDto.getId());
		appointment.setPname(appointmentDto.getPname());
		appointment.setPphone(appointmentDto.getPphone());
		appointment.setConcern(appointmentDto.getConcern());
		appointment.setDescription(appointmentDto.getDescription());
		appointment.setDates(appointmentDto.getDates());
        Hospital hospital = new Hospital();
		hospital.setId(appointmentDto.getHospital().getId());
	    appointment.setHospital(hospital);
		Patient patient = new Patient();
		patient.setId(appointmentDto.getPatient().getId());
		appointment.setPatient(patient);
		return appointment;

}
}
