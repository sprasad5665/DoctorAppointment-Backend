package com.doctor.BackendApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.BackendApp.dto.FeedbackDto;
import com.doctor.BackendApp.model.FeedBack;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.service.IFeedBackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedBackController {
	private static Logger LOGGER = LoggerFactory.getLogger(FeedBackController.class);

	@Autowired
	private IFeedBackService iFeedBackService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	FeedBack createAppointment(@RequestBody FeedbackDto feedbackDto) {
		return iFeedBackService.addFeedBack(feedbackDto);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllFeedBack")
	List<FeedBack> all() {
		return iFeedBackService.getAllFeedBack();
	}

}
