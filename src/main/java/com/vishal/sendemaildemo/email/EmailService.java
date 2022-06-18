package com.vishal.sendemaildemo.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vishal.sendemaildemo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface EmailService {

	public void sendEmail(String to, String subject,String body);

	//ResponseEntity<?> sendEmailFromTemplate()
	//		throws JsonMappingException, JsonProcessingException, ResourceNotFoundException;
}
