package com.example.webbanhangfinal.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.Repository.ConfirmTokenRepository;
import com.example.webbanhangfinal.auththenticate.Register.UserToken.ConfirmationUserToken;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTokenService {
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
