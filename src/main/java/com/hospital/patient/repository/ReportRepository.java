package com.hospital.patient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Report;

public interface ReportRepository  extends JpaRepository<Report, String> {
	List<Report> findByPatientId(Long patientId);

	void deleteById(Long id);

	Optional<Report> findById(Long id);
}
