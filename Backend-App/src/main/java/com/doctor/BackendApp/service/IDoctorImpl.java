package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.repository.IDoctorRepository;
import com.doctor.BackendApp.repository.IPatientRepository;
import com.doctor.BackendApp.service.IPatientService;

@Component
public class IDoctorImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return iDoctorRepository.findAll();
	}



}
