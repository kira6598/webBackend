package com.example.webbanhangfinal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webbanhangfinal.UserCartManager.Cart;

import jakarta.transaction.Transactional;
@Repository
public interface UserCartRepository extends JpaRepository<Cart,String> {
    Optional<Cart> findById(String id);
    long count();
    
    @Query(value = "SELECT * FROM web_information.cart1 WHERE user_id=:user_id AND product_id=:product_id",nativeQuery = true)
    Cart getCart(@Param("user_id") Integer userId,@Param("product_id")String productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE web_information.cart1 SET quantity=:quantity where id=:id",nativeQuery = true)
    void updateQuantity(@Param("quantity") Integer quantity,@Param("id") Integer id );
}
