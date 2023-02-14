package com.example.webbanhangfinal.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.Repository.UserRepository;
import com.example.webbanhangfinal.auththenticate.Register.UserToken.ConfirmationUserToken;
import com.example.webbanhangfinal.auththenticate.UserManagerment.AppUser;
import com.example.webbanhangfinal.auththenticate.UserManagerment.AppUserException;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserTokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        return userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Not found user"));
    }
    public String SignUpUser(AppUser user) throws AppUserException{
        boolean isUserExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if(isUserExist){
           throw new AppUserException("user is exist!");
        }
        String password = passwordEncoder.encode(user.getPassword());
        user.setEnabled(true);
        user.setPassword(password);
        userRepository.save(user);
        String userToken = UUID.randomUUID().toString();
        ConfirmationUserToken confirmationToken = new ConfirmationUserToken(userToken, LocalDateTime.now(),  LocalDateTime.now().plusMinutes(15), user);
        tokenService.saveConfirmationToken(confirmationToken);
        return userToken;
    }
    public int enableUser(AppUser user){
        return userRepository.enableAppUser(user.getEmail());
        
    }
    public boolean getEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
         }
    
    
}
