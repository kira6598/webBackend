package com.example.webbanhangfinal.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.webbanhangfinal.MVC.Model.Cart;
import jakarta.transaction.Transactional;
@Repository
public interface CartRepository extends JpaRepository<Cart,String> {
    Optional<Cart> findById(String id);   
    @Query(value = "SELECT COUNT(*) as cao FROM webbando.cart1 WHERE client_id=:userid", nativeQuery =true)
    Integer getCountItemById(@Param("userid") Integer id);

    @Query(value = "SELECT * FROM webbando.cart1 WHERE client_id=:user_id AND product_id=:product_id",nativeQuery = true)
    Cart getCart(@Param("user_id") Integer userId,@Param("product_id")String productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE webbando.cart1 SET quantity=:quantity where id=:id",nativeQuery = true)
    
    // this int return type says how many rows were modified by Query
    int updateQuantity(@Param("quantity") Integer quantity,@Param("id") Integer id );

    // @Query(value = "SELECT cart1.product_id as id,product.product_name as productName,cart1.quantity as quantity,product.price as price, cart1.total as total,product.image as img  FROM webbando.cart1 inner join product on cart1.product_id=product.id where client_id=:client_id",nativeQuery = true)
    // List<DetailCart> getCartById(@Param("client_id")Integer id);    

    @Transactional
    @Modifying
    @Query(value = "call insert_cart_item(:quantity,:client_id,:product_id)",nativeQuery = true)
    int addCartWithSP(@Param("quantity")Integer quantity,@Param("client_id") Integer client_id,@Param("product_id") String product_id  );

   
    @Query(value = "SELECT cart1.product_id as id,product.product_name as productName,cart1.quantity as quantity,product.price as price, cart1.total as total,product.image as img  FROM webbando.cart1 inner join product on cart1.product_id=product.id where client_id=:client_id",nativeQuery = true)
    List<DetailCart> getCartByUserId(@Param("client_id")Integer id);    
    
    @Transactional
    @Modifying
    @Query(value = "delete from cart1 where client_id =?1 and product_id=?2",nativeQuery = true)
    int deleteCartById(Integer clientId,String productId);

}


