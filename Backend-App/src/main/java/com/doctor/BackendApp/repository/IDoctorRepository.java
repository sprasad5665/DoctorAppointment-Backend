package com.doctor.BackendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
	
	

}
