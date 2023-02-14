package com.example.webbanhangfinal.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.Repository.UserCartRepository;
import com.example.webbanhangfinal.UserCartManager.Cart;
import com.example.webbanhangfinal.UserCartManager.CartRespone;
import com.example.webbanhangfinal.UserCartManager.addRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
@RequiredArgsConstructor
public class userCartService {
    private final UserCartRepository cartRepository;

    public long getCart(){
        return cartRepository.count();
    }

    public ResponseEntity<CartRespone> addCartFromRequest(addRequest request) {
        Integer userId=request.user();
        String productId = request.product();
        Cart cart = cartRepository.getCart(userId, productId);
        if(cart!=null){
            
            cartRepository.updateQuantity(request.quantity(),cart.getId());
        }
        return null;
    }
     
    public void addCart(Cart item){
        Integer userId=item.getClient().getId();
        String productId = item.getProduct().getId();
        Cart cart = cartRepository.getCart(userId, productId);
        if(cart!=null){
            log.info("update Quantity");
            cartRepository.updateQuantity(item.getQuantity(),cart.getId() );
        }else{
            log.info("add Item");
            cartRepository.save(item);
        }
        
    }

}
