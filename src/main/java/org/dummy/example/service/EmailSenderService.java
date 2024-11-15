
package org.dummy.example.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.dummy.example.config.EmailConfig;

public class EmailSenderService {

  public void sendEmail(String recipient, String subject, String body) {
    Session session = EmailConfig.createEmailSession();

    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(EmailConfig.getSenderEmail()));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
      message.setSubject(subject);
      message.setText(body);

      Transport.send(message);
      System.out.println("Email sent successfully to " + recipient);
    } catch (MessagingException e) {
      e.printStackTrace();
      System.err.println("Failed to send email to " + recipient);
    }
  }
}
