package com.hospital.patient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Prescription;

public interface PrescriptionRepository  extends JpaRepository<Prescription, String>{
	List<Prescription> findByPatientId(Long patientId);
	List<Prescription> findByAppointmentId(Long appointmentId);

	void deleteById(Long id);

	Optional<Prescription> findById(Long id);

}
