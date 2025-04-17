package org.jsp.studentmanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String to) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("tonysri.arpula153@gmail.com");
		message.setSubject("Confirmation Regarding signUp");
		message.setText("Account created Successfully");
		
		mailsender.send(message);
	}

	public void sendEmailForLogin(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("tonysri.arpula153@gmail.com");
        message.setSubject("Login information");
        message.setText("Account logged in Successfully");

        mailsender.send(message);
    }
}
