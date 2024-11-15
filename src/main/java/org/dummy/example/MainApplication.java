package org.dummy.example;

import org.dummy.example.service.EmailSenderService;

public class MainApplication {

  public static void main(String[] args) {
    EmailSenderService emailSender = new EmailSenderService();

    // Example usage
    String recipient = "recipient@example.com";
    String subject = "Test Subject";
    String body = "Hello! This is a test email.";
    emailSender.sendEmail(recipient, subject, body);
  }
}
