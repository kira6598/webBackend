package com.example.webbanhangfinal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webbanhangfinal.MVC.Model.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel,String> {
    Optional<ProductModel> findById(String id);
    long count();
    @Query(value = "SELECT COUNT(*) FROM webbando.product",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT * FROM webbando.product WHERE product_name LIKE ?1% ",nativeQuery = true  )
    List<ProductModel> getByName(String name);
}