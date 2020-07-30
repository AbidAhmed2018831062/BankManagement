package students;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendingEmail {
	SendingEmail(String s)
	{
		emailsent(s);
	}

	public void emailsent(String s) {
		//authentication info
		final String username = "ahmedabidfa12@gmail.com";
		final String password = "CGC7yKG5Mdmpj2z";
		String fromEmail = "ahmedabidfa12@gmail.com";
		//String toEmail = "ahmedabid3409@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		Message m=prepareMessage(session,fromEmail,s);
       try {
		Transport.send(m);
		System.out.println(s);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static Message prepareMessage(Session s,String em,String to) {
		// TODO Auto-generated method stub
		Message m=new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(em));
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    m.setSubject("Security Alert");
		    m.setText("Sir,Your Sust student management account password has beeen changed.");
		   return m;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}