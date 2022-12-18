package spring.service;

import java.util.Properties;



import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	public void sendEmail(String subject, String message,String to) {
		
		String from="onlinedukaan.local@gmail.com";
		
		String host="smtp.gmail.com";
		
		//fetching system properties
		Properties properties=System.getProperties();
		System.out.println("Properties "+properties);
		
		//Setting information to properties object
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step-1 Getting session object
		Session session=Session.getInstance(properties,new Authenticator() {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication("onlinedukaan.local@gmail.com","qccjitvpqiaquzks");
	}
	
});
		session.setDebug(true);
		//Step-2 Compose message
		MimeMessage context= new MimeMessage(session);
		try {
			context.setFrom(from);
			
			//adding recipient to message
			context.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			context.setSubject(subject);
			
			//adding text to message
			context.setText(message);
			
			//send
			//Step-3 Send message using transport class
			Transport.send(context);
			System.out.println("Sent successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
