package com.doctor.BackendApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>  {

	

}
