package com.example.webbanhangfinal.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.webbanhangfinal.UserManagerment.AppUserException;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRespone;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<LoginRespone> handleAuthenticationEx(AuthenticationException e){
          log.error("an error authentication at: ", e);
          switch (e.getMessage()) {
            case "User is disabled":
            LoginRespone loginRespone = new LoginRespone(null,null,"User is disabled",0);
                return ResponseEntity.status(403).body(loginRespone);
            case "Bad credentials":
            LoginRespone loginRespone1 = new LoginRespone(null,null,"password is incorrect!",0);
                return ResponseEntity.status(403).body(loginRespone1);             


                
          
            default:
            LoginRespone defaultLoginRespone = new LoginRespone(null,null,"unknow error, we will fix it soon!!",0);
            return ResponseEntity.status(403).body(defaultLoginRespone);
          }
        
    }@ExceptionHandler({AppUserException.class})
    public ResponseEntity<String> handleUserEx(AppUserException e){
          log.error("an error authentication at: ", e);
        return ResponseEntity.status(403).body("null");
    }
  
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        // Log lỗi ra và ẩn đi message thực sự (xem phần 3.2)
        log.error("an error authentication at: ", e);
        return ResponseEntity.status(500).body("Unknow error"+e.getCause());
    }

}
