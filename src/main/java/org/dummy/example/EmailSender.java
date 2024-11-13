package org.dummy.example;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

  public static void sendEmail(String recipient, String subject, String body) {
    // Set up properties for the mail session
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.example.com"); // SMTP server (e.g., smtp.gmail.com)
    props.put("mail.smtp.port", "587"); // SMTP port (587 for TLS)
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    // Authenticator for email
    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("your_email@example.com", "your_password");
      }
    });

    try {
      // Create email message
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("your_email@example.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
      message.setSubject(subject);
      message.setText(body);

      // Send email
      Transport.send(message);
      System.out.println("Email sent successfully to " + recipient);
    } catch (MessagingException e) {
      e.printStackTrace();
      System.out.println("Failed to send email");
    }
  }

  public static void main(String[] args) {
    // Call the sendEmail method with sample data
    sendEmail("recipient@example.com", "Test Subject", "Hello! This is a test email.");
  }
}
