package com.example.webbanhangfinal.MVC.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.MVC.Model.AppUser;
import com.example.webbanhangfinal.Repository.UserRepository;
import com.example.webbanhangfinal.UserManagerment.AppUserException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/data/user")
    public AppUser getAppUser(String email) throws AppUserException{
        return userRepository.findByEmail(email).orElseThrow(()->  new AppUserException("user not found!"));
        
    }
}
