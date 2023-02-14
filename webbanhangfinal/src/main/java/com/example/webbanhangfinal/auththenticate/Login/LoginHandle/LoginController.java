package com.example.webbanhangfinal.auththenticate.Login.LoginHandle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.Service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginRespone> authenticate(@RequestBody LoginRequest request){
      
        return loginService.authenticateRequest(request);
    }

}
