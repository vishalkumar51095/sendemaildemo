package com.vishal.sendemaildemo.email;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vishal.sendemaildemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

	
	@Autowired
    private JavaMailSender emailSender;
	
	/*@Autowired
	private MailSender mailsender;*/

	@Value("${spring.mail.username}")
	private String from;

	@Override
	public void sendEmail(String to, String subject,String body)
	{  
		//Multipurpose Internet Mail Extensions (MIME)
		 MimeMessage mimeMessage = emailSender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		 try {
	
		 helper.setText(body, true);
		 helper.setTo(to);
		 helper.setSubject(subject);
		 
			try {
				helper.setFrom(from,"vishalkumar51095@gmail.com");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(mimeMessage);
		
		System.out.println("Email Sent To "+to);
	}


	
}
