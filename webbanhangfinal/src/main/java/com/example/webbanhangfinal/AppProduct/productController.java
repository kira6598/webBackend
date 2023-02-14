package com.example.webbanhangfinal.AppProduct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhangfinal.Service.productService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class productController {
    private final productService productService;
    @GetMapping("/count")
    public long getEntity(){
        return productService.getCount();
    }
}
