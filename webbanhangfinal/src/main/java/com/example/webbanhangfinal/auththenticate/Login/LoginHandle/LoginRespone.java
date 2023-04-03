package com.example.webbanhangfinal.auththenticate.Login.LoginHandle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@AllArgsConstructor
public class LoginRespone {
    private Integer userid;
    private String username;
    private String token;
    private long countCart;
}
