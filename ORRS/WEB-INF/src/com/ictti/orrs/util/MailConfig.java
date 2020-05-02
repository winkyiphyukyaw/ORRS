package com.ictti.orrs.util;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConfig {
	private static final String SMTP_HOST_NAME="192.168.48.13";
		
	public void sendToOne(String recipient,String subject,String message,String from)throws MessagingException{
		boolean debug=false;
		
		//1
		Properties props=new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		Session session=Session.getDefaultInstance(props);
		session.setDebug(debug);
		
		//2
		Message msg=new MimeMessage(session);
		
		//3
		InternetAddress addressFrom=new InternetAddress(from);
		msg.setFrom(addressFrom);		
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		
		//4
		msg.setSubject(subject);
		msg.setContent(message,"text/plain");
		
		//5
		Transport.send(msg);		
	}
	
	
}