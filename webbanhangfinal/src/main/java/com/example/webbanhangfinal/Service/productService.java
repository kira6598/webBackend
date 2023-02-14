package com.example.webbanhangfinal.Service;

import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.Repository.productRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class productService {
private final productRepository pRepository;
    public long getCount() {
        return pRepository.count();
    }
    
}
