package com.doctor.BackendApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	User findByuserName(String userName);
	
	

}
