package com.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Report;

public interface ReportRepository  extends JpaRepository<Report, String> {

}
