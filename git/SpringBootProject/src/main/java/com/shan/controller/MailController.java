package com.shan.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shan.dao.EmployeeDao;
import com.shan.dao.UserDao;
import com.shan.model.Employee;

@RestController
public class MailController {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@RequestMapping("/sendMail/{id}")
	public String sendingEmail(@PathVariable ("id") int id) {
		
	MimeMessage msg=sender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(msg);
	try {
		
	helper.setTo(userDao.findById(id).getEmail());
	
	helper.setText("welcome to on-Board into E-office Corp."
			+ "Welcome" + employeeDao.findById(id).getFname()+ "your details as below:-\n" + "empId:" 
			+ employeeDao.findById(id).getId() + "Loginid:" + employeeDao.findById(id).getEmail() + 
			"Your Password is:" + Employee.getFname.substring(0,2)+Employee.getLname.substring(0,2)+Employee.getJoining_date);
	
	
	}catch(MessagingException e) {
		e.printStackTrace();
		return "Exception while sending mail...";
	}
	sender.send(msg);
	return "Mail send successfully!!!";
	}
}
