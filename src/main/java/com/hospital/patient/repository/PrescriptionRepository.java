package com.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Prescription;

public interface PrescriptionRepository  extends JpaRepository<Prescription, String>{

}
