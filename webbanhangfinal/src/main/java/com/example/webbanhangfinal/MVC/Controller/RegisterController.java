package com.example.webbanhangfinal.MVC.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.MVC.Service.RegisterService;
import com.example.webbanhangfinal.UserManagerment.AppUserException;
import com.example.webbanhangfinal.auththenticate.Register.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws AppUserException{
        String results= registerService.registerRequest(request);
        switch (results) {
            case "email is invalid":
                return ResponseEntity.status(406).body("email is invalid");
            case "Success":
                return ResponseEntity.ok("Success"); 
            case "email is exist":
                return ResponseEntity.status(400).body("email is exist");        
            default:
                return ResponseEntity.status(500).body("an error happen when sending email");
        }
    }
    
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token){
        
        return registerService.confirmToken(token);
    }
}
