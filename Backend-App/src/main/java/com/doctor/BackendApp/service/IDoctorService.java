package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;


public interface IDoctorService {
	
	 List<Doctor> getAllDoctor();

}
