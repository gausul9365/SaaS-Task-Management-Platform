package com.completefocus.controller;
import com.completefocus.service.*;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        try {
            emailService.sendSimpleMail(to, subject, body);
            return "Email sent successfully.";
        } catch (MessagingException e) {
            return "Error: " + e.getMessage();
        }
    }
}
