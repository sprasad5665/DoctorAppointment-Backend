package com.doctor.BackendApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.service.IDoctorService;
import com.doctor.BackendApp.service.IPatientService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private IDoctorService iDoctorService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllDoctors")
	List<Doctor> all() {
		return iDoctorService.getAllDoctor();
	}

}
