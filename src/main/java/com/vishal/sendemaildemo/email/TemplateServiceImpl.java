package com.vishal.sendemaildemo.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vishal.sendemaildemo.email.EmailTemplate;
import com.vishal.sendemaildemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateServiceImpl {

    @Autowired
    EmailTemplate emailTemplate;

	public ResponseEntity<?> sendEmailFromTemplate()
			throws JsonMappingException, JsonProcessingException, ResourceNotFoundException {

		Map<String,String> map=new HashMap<String,String>();
		//Send Email
		String to="vishalkumar051095@gmail.com";
		String title="Subject";
	//	EmailModel emailModel=new EmailModel("vishalkumar51095@gmail.com","Subject");
		try {

				emailTemplate.sendEmailTemplate(to,title);

				System.out.println("Email Sent To " + to);
				map.put("message", "success");

		}
		catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		return ResponseEntity.ok(map);
	}

}
