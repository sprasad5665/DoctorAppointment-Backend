package com.doctor.BackendApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.BackendApp.dto.UserDetailsDto;
import com.doctor.BackendApp.model.User;
import com.doctor.BackendApp.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@CrossOrigin
	@PostMapping(value = "/Login")
	ResponseEntity<User> getUserByUserName(@RequestBody UserDetailsDto userDetailsDto) {
		return iUserService.getUserByUsername(userDetailsDto);
	}

}
