
package org.dummy.example.config;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailConfig {

  private static final String SMTP_HOST = "smtp.example.com";
  private static final String SMTP_PORT = "587";
  private static final String EMAIL = "your_email@example.com";
  private static final String PASSWORD = "your_password";

  public static Session createEmailSession() {
    Properties props = new Properties();
    props.put("mail.smtp.host", SMTP_HOST);
    props.put("mail.smtp.port", SMTP_PORT);
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    return Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(EMAIL, PASSWORD);
      }
    });
  }

  public static String getSenderEmail() {
    return EMAIL;
  }
}
