package com.testing.emailreport;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.joda.time.DateTime;

import com.testing.constants.Constants;




public class MailReport {
 
	public static void createMail() {
		
		final String fromEmail = Constants.USERNAME; //requires valid gmail id
		final String password = Constants.PASSWORD; // correct password for gmail id
		final String toEmail = "tal42201@gmail.com"; // can be any email id 
		final String reportFileName = "Test-Automaton-Report"+".html";
		final String fileSeperator = System.getProperty("file.separator");
		final String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
		final String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        //EmailUtil.sendEmail(session, toEmail,"Test-Automation-Report", "Automatic generated mail");

	        EmailUtil.sendAttachmentEmail(session, toEmail,"Automatic QA Report for the: " + DateTime.now(), 
	        		"Check the attached file to see the test results." + "\n\n"
	        		+ "thanks, \n\n" 
	        		+ "QA Team ",reportFileLocation);

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

	
 
	}
 
}