package com.hospital.patient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.Event;
public interface EventRepository extends JpaRepository<Event, String> {

	List<Event> findByHospitalId(Long hospitalId);

	void deleteById(Long id);

	Optional<Event> findById(Long id);
}
