package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doctor.BackendApp.dto.UserDetailsDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.model.User;
import com.doctor.BackendApp.repository.IPatientRepository;
import com.doctor.BackendApp.repository.IUserRepository;
import com.doctor.BackendApp.service.IPatientService;

@Component
public class IUserImpl implements IUserService {
	
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public ResponseEntity<User>  getUserByUsername(UserDetailsDto userDetailsDto) {
		//System.out.println("get data "+ userDetailsDto.getUserName());
		User user = null;
		try {
		 user = iUserRepository.findByuserName(userDetailsDto.getUserName());
		 if(user == null || !user.getPassword().equalsIgnoreCase(userDetailsDto.getPassword())) {
			 return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		 }else{
			 return new ResponseEntity<>(user, HttpStatus.OK);
		 }
		
		}catch(Exception e) {
			System.out.println("Exception "+ e);
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
