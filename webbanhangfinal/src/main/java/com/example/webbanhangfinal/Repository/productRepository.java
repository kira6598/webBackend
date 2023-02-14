package com.example.webbanhangfinal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webbanhangfinal.AppProduct.productModel;
@Repository
public interface productRepository extends JpaRepository<productModel,String> {
    Optional<productModel> findById(String id);
    long count();
}
