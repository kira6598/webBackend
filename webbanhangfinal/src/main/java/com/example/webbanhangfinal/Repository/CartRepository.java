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
    @Query(value = "SELECT COUNT(*) as cao FROM webbando.cart WHERE client_id=:userid", nativeQuery =true)
    Integer getCountItemById(@Param("userid") Integer id);

    @Query(value = "SELECT * FROM webbando.cart WHERE client_id=:user_id AND product_id=:product_id",nativeQuery = true)
    Cart getCart(@Param("user_id") Integer userId,@Param("product_id")String productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE webbando.cart SET quantity=:quantity where id=:id",nativeQuery = true)
    
    // this int return type says how many rows were modified by Query
    int updateQuantity(@Param("quantity") Integer quantity,@Param("id") Integer id );

    @Transactional
    @Modifying
    @Query(value = "call insert_cart(?1,?2,?3)",nativeQuery = true)
    int addCartWithStoredProcedure(Integer quantity,Integer client_id, String product_id  );

   
    @Query(value = "SELECT cart.product_id as id,product.product_name as productName,cart.quantity as quantity,product.price as price, cart.total as total,product.image as img  FROM webbando.cart inner join product on cart.product_id=product.id where client_id=:client_id",nativeQuery = true)
    List<DetailCart> getCartByUserId(@Param("client_id")Integer id);    
    
    @Transactional
    @Modifying
    @Query(value = "delete from cart where client_id =?1 and product_id=?2",nativeQuery = true)
    int deleteCartById(Integer clientId,String productId);

    @Transactional
    @Modifying
    @Query(value = "delete from cart where client_id =?1 ",nativeQuery = true)
    int deleteAllById(String userID);
}


