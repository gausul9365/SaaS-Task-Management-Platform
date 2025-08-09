package com.completefocus.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendSimpleMail(String to, String subject, String body) throws MessagingException;
}
