package com.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);




	User findOneByUsernameIgnoreCaseAndPass(String username, String pass);

}
