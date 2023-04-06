package com.hospital.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patient.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

	Hospital findOneById(long id);

	List<Hospital> findByNameContaining(String name);

}
