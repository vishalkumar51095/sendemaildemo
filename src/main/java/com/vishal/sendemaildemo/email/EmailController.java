package com.vishal.sendemaildemo.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vishal.sendemaildemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private TemplateServiceImpl templateService;

	//@EventListener(ApplicationReadyEvent.class)
	@PostMapping("/email")
	public String sendEmail(String to, String subject, String body)
	{   
		emailService.sendEmail("vishalkumar051095@gmail.com", "email send","hello" );
		return "Succees";
	}

	@PostMapping("/email-template")
	public String sendEmailFromTemplate() throws ResourceNotFoundException, JsonProcessingException {
		templateService.sendEmailFromTemplate();
		return "Succees";
	}


}

