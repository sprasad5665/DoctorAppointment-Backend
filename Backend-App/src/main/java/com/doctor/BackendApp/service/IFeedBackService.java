package com.doctor.BackendApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.doctor.BackendApp.dto.FeedbackDto;
import com.doctor.BackendApp.model.FeedBack;

public interface IFeedBackService {
	
	FeedBack addFeedBack(FeedbackDto feedbackDto);
	ResponseEntity<FeedBack> getFeedBack(FeedBack feedBack);
	List<FeedBack> getAllFeedBack();

}
