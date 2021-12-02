/**
* This class describes services for Mail.
* Methods for confirmation of Mail ID, format of mail and sending an email to Mail id.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.EmailTemplate;
import com.ibm.utils.*;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailer;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public boolean sendMail(String email, String subject, String body) {
		MimeMessage mail = mailer.createMimeMessage();
		
		try {
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setFrom(fromEmail);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailer.send(mail);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	
	public boolean sendOtpMail(String email, int otp){
		try {
			EmailTemplate template = FileUtil.readOtpEmailTemplate();
			template.body = String.format(template.body, String.valueOf(otp));
			
			return sendMail(email, template.subject, template.body);			
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		} 
	}
	public boolean sendOrderSuccessMail(String email, Float amount) {
		try {
			EmailTemplate template = FileUtil.readOrderSuccessEmailTemplate();
			template.body = String.format(template.body, (amount > 0 ? "of amount " + amount.toString() : ""));
			
			return sendMail(email, template.subject, template.body);			
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		} 
	}
}
