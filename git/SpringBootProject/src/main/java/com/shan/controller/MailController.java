package com.shan.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping("/sendMail")
	public String sendingEmail() {
	MimeMessage msg=sender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(msg);
	try {
	helper.setTo("flowershan3@gmail.com");
	helper.setText("welcome to on-Board into E-office Corp.");
	
	
	}catch(MessagingException e) {
		e.printStackTrace();
		return "Exception while sending mail...";
	}
	sender.send(msg);
	return "Mail send successfully!!!";
	}
	
}
