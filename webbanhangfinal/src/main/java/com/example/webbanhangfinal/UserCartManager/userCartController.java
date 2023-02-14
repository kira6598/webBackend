package com.example.webbanhangfinal.UserCartManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.Service.userCartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class userCartController {
    private final userCartService userCartService;
    @PostMapping("/addToCart")
    public ResponseEntity<CartRespone> addtoCart(@RequestBody addRequest request){
        return userCartService.addCartFromRequest(request);
    }
}
