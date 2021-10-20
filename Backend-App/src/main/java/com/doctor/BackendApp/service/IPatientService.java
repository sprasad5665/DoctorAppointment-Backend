package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;


public interface IPatientService {
	
	 Patient addPatient(Patient patient);
	 Patient updatePatientDetails(Patient patient);
	 Patient removePatientDetails(Patient patient);
	 Patient getPatient(Patient patient);
	 List<Patient> getAllPatient();
	 List<Patient> getPatientListByDoctor(Doctor doctor);
	 List<Patient> getPatientListByDate(LocalDate Date);

}
