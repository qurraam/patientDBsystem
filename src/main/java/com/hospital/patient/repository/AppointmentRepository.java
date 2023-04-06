package com.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	Appointment findOneById(long id);

}
