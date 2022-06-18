package com.vishal.sendemaildemo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplate {

	@Autowired
	EmailService emailService;

	@Async
	public void sendEmailTemplate(String to, String title)
	{
		
		 String Subject="Email Send from template- "+title+"";
		 
			String body="Hello ,<br/><br/>  I am sending mail by template"+
					"This mail is send only for Demo purpose"+
					"<br/>"+
					"<br/>"+
	               "Regards,"+
	               "<br/>"+
	               "Vishal Kumar";
					
			//Send Email
		 	emailService.sendEmail(to,Subject, body);
		
	}
	
}
