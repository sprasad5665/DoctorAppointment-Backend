package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.doctor.BackendApp.dto.AppointmentDetailsForAdminDto;
import com.doctor.BackendApp.dto.AppointmentDto;
import com.doctor.BackendApp.dto.UserDetailsDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.User;

public interface IUserService {
	
	ResponseEntity<User>  getUserByUsername(UserDetailsDto userDetailsDto);

	


}
