package com.example.webbanhangfinal.MVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.MVC.Model.ProductModel;
import com.example.webbanhangfinal.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
private final ProductRepository pRepository;
    public Integer getCount() {
        return pRepository.getCount();
    }
    public Optional<ProductModel> getProductById(String product) {
        return pRepository.findById(product);
    }
    public void addProduct(ProductModel product) {
        pRepository.save(product);
    }
    public List<ProductModel> getProductByName(String name) {
        return pRepository.getByName(name);
    }
    
}
