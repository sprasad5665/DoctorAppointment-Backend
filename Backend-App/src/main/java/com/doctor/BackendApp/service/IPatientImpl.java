package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.repository.IPatientRepository;
import com.doctor.BackendApp.service.IPatientService;

@Component
public class IPatientImpl implements IPatientService {
	
	@Autowired
	private IPatientRepository iPatientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient removePatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return iPatientRepository.findAll();
	}

	@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientListByDate(LocalDate Date) {
		// TODO Auto-generated method stub
		return null;
	}

}
