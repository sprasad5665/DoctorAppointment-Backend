package com.doctor.BackendApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.BackendApp.dto.AppointmentDetailsForAdminDto;
import com.doctor.BackendApp.dto.AppointmentDto;
import com.doctor.BackendApp.dto.FeedbackDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.FeedBack;
import com.doctor.BackendApp.service.IAppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	private IAppointmentService iAppointmentService;


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getAppointmentsForAdmin")
	List<AppointmentDetailsForAdminDto> all() {
		return iAppointmentService.getAllAppointmentsForAdmin();
	}

	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Appointment> removeAppointment(@PathVariable Integer id) {
		LOGGER.debug("url has been hit");
		return iAppointmentService.deleteAppointment(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}")
	ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Integer id) {
		LOGGER.debug("url has been hit");
		return iAppointmentService.getAppointment(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	Appointment createAppointment(@RequestBody AppointmentDto appointmentDto) {
		return iAppointmentService.addAppointment(appointmentDto);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	Appointment updateAppointment(@PathVariable Integer id,@RequestBody AppointmentDto appointmentDto) {
		return iAppointmentService.updateAppointment(appointmentDto,id);
	}

}
