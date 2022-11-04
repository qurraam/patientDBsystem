package com.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

	Hospital findOneById(long id);

}
