package com.example.webbanhangfinal.auththenticate.Register.Email;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {
    void Send(String to,String emailContent);
}
