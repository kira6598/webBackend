package com.example.webbanhangfinal.MVC.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.MVC.Service.LoginService;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRequest;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRespone;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginRespone> authenticate(@RequestBody LoginRequest request){
        LoginRespone respone = loginService.authenticateRequest(request);
        if(respone.getUsername()==null){
            return ResponseEntity.status(403).body(respone);
        }else{
            return ResponseEntity.ok(respone);
        }
      
      
    }

}
