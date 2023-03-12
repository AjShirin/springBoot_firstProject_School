package com.codeline.API.APIProjectFirst_Shirin.mailing.service;

import com.codeline.API.APIProjectFirst_Shirin.mailing.models.EmailDetails;
import com.codeline.API.APIProjectFirst_Shirin.mailing.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailService implements EmailRepository {

    @Autowired
    private JavaMailSender mailSender; // gives functionality to send emails, this comes from java

    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public String sendSimpleMailToMany(EmailDetails emailDetails) {
        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage(); // the class comes from the starter email we created and has many features , mailMessage already has attributes

            List<String> mailingList = emailDetails.getRecipient(); // getting the list of people and putting it in the mailingList variable
            for (String email : mailingList) { // the for loop variable  has all the emails
                // Setting up necessary details
                mailMessage.setFrom(sender); // variable stores your username
                mailMessage.setTo(email); // variable stores the email
                mailMessage.setText(emailDetails.getMsgBody());
                mailMessage.setSubject(emailDetails.getSubject());

                // Sending the mail
                mailSender.send(mailMessage); // this object is coming from java
            }

            return "Mail Sent Successfully.. :)";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail Please try again :(";
        }
    }

    @Override
    public String sendMailWithAttachmentToMany(EmailDetails emailDetails) {
        // Creating a mime message
        // send simple text email as well as HTML email using MimeMessageHelper class.
        MimeMessage mimeMessage = mailSender.createMimeMessage(); // mime is built in java
        MimeMessageHelper mimeMessageHelper; // helper class  has all the function that we need/ helps in conversion

        try {
            List<String> mailingList = emailDetails.getRecipient();

            // Setting multipart as true for attachments to be sent
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true); //  1 object , 1 boolean
            mimeMessageHelper.setFrom(sender);

            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment())); // (emailDetails.getAttachment()) file attachment path

            mimeMessageHelper.addAttachment(file.getFilename(), file); // create a file object and cal it

            // Sending the mail
            for (String email : mailingList) {
                mimeMessageHelper.setTo(email);
                mailSender.send(mimeMessage);
            }

            return "Mail sent Successfully :)";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail please try again :(";
        }
    }

    public String sendSimpleMail(EmailDetails details) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient().get(0));
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully.. :)";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail Please try again :(";
        }
    }
    @Override
    public String sendMailWithAttachment(EmailDetails emailDetails) {
        // Creating a mime message
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to be sent
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient().get(0));
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            mailSender.send(mimeMessage);
            return "Mail sent Successfully :)";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail please try again :(";
        }
    }
}