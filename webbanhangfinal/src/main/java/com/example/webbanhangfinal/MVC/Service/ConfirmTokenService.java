package com.example.webbanhangfinal.MVC.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.MVC.Model.ConfirmationUserToken;
import com.example.webbanhangfinal.Repository.ConfirmTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfirmTokenService {
private final ConfirmTokenRepository tokenRepository;
    public void saveConfirmationToken(ConfirmationUserToken confirmationToken) {
        tokenRepository.save(confirmationToken);
    }
    public Optional<ConfirmationUserToken> getToken(String token){
        return tokenRepository.findByToken(token);
    }
    public int SetConfirmAt(String token){
        return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
