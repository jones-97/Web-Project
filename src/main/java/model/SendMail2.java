/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class SendMail2 {
     public void email(String email, String usPwd) throws AddressException, MessagingException {

                String toAddress = email;
                String fromAddress = "jonesmwaniki@ymail.com";

                final String username = "jonesmwaniki@ymail.com";
                final String password = "bjqbbvsbaqlpylfd";
                String smtphost = "smtp.mail.yahoo.com";

                Properties props = new Properties();
                props.put("mail.smtp.host", smtphost);
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", false);
                props.put("mail.smtp.port", "587");

//                props.put("mail.smtp.ssl.enable", "true");
                
                props.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
                session.setDebug(true);
                
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("jonesmwaniki@ymail.com"));
                message.setRecipients(Message.RecipientType.TO,
                       InternetAddress.parse(toAddress)
                );
                message.setSubject("Success! Email Registration complete.");
                message.setText("Dear User, you have successfully registered to our site. \n"
                        + "Find below your generated Password, which you will use to log in.\n\n"
                        + "Password: " + usPwd + "\n\n");
                 
                Transport.send(message);

                System.out.println("Done. Email sent");
     }
}
