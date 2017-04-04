package com.medeiros.ordnael.core.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public void sendEmail() throws EmailException {

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ordnaelmedeiros@gmail.com", "xxxx"));
		email.setSSLOnConnect(true);
		email.setFrom("ordnaelmedeiros@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail 2 ... :-)");
		email.addTo("lrmarkanjo@gmail.com");
		email.send();

		//https://myaccount.google.com/lesssecureapps?pli=1
		
	}

}
