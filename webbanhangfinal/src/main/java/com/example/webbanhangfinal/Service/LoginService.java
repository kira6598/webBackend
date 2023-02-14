package com.example.webbanhangfinal.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.Repository.UserRepository;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRequest;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRespone;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final AppUserService userService;



    public ResponseEntity<LoginRespone> authenticateRequest(LoginRequest request) {
        if(!userService.getEmail(request.email())){
            LoginRespone respone = new LoginRespone(null,"user is not exist!");
            return ResponseEntity.status(403).body(respone);  
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
               );

       var user = userRepository.findByEmail(request.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        LoginRespone respone = new LoginRespone(user.getFirstname()+" "+user.getLastname(),jwtToken);
         return ResponseEntity.ok().body(respone);
    }

   
    
}
