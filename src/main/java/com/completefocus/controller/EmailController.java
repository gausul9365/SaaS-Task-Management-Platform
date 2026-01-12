package com.completefocus.controller;

import com.completefocus.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Existing plain text email endpoint
    @PostMapping("/send")
    public String sendMail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        try {
            emailService.sendSimpleMail(to, subject, body);
            return " Email sent successfully.";
        } catch (MessagingException e) {
            return " Error: " + e.getMessage();
        }
    }

    // Updated HTML email endpoint (can send daily OR weekly) 
    @PostMapping("/send-html")
    public String sendHtmlMail(
            @RequestParam String to,
            @RequestParam(defaultValue = "daily-report") String template) {

        try {
            Map<String, Object> variables = new HashMap<>();
            variables.put("date", LocalDate.now().toString());
            variables.put("userName", "Khurram");
            variables.put("goalsSet", 5);
            variables.put("goalsCompleted", 3);
            variables.put("tasksDone", 12);
            variables.put("timeSpent", 240);

            // pick subject based on template
            String subject = template.equals("weekly-report") ? "Weekly Report" : "Daily Report";

            emailService.sendHtmlMail(to, subject, variables, template);

            return "✔ " + template + " email sent successfully to " + to;
        } catch (MessagingException e) {
            return "X Error: " + e.getMessage();
        }
    }
}
