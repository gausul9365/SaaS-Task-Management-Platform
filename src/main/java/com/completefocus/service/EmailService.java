package com.completefocus.service;

import jakarta.mail.MessagingException;
import java.util.Map;

public interface EmailService {
    void sendSimpleMail(String to, String subject, String body) throws MessagingException;

    // updated to accept templateName too
    void sendHtmlMail(String to, String subject, Map<String, Object> variables, String templateName) throws MessagingException;
}
