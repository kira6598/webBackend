package com.example.webbanhangfinal.MVC.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.webbanhangfinal.CartManager.addRequest;
import com.example.webbanhangfinal.CartManager.changeRequest;
import com.example.webbanhangfinal.MVC.Model.Cart;
import com.example.webbanhangfinal.Repository.CartRepository;
import com.example.webbanhangfinal.Repository.DetailCart;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;

    public Integer getCountItemByEmail(String email){
        Integer userId =userService.getIdByEmail(email);
        Integer count =cartRepository.getCountItemById(userId);
        return count;}
    public Integer getCountItemByUserId(Integer id){
            Integer count =cartRepository.getCountItemById(id);
            return count;}
       

    public int addCartFromRequest(addRequest request) {
        Integer clientId=request.userid();
        String productId = request.productid();
        Integer quatity = request.quantity();
        Cart cart = cartRepository.getCart(clientId, productId);
        if(cart==null){                       
            int result=cartRepository.addCartWithStoredProcedure(quatity,clientId,productId);// init cart's id            
            return result;
        }else{
            return 0;
            
        }
      
    }
    public String changeQuantity(changeRequest request) {
        Cart cart = cartRepository.getCart(request.client(), request.product());
        if(cart==null){
            return "bad request";
        }else{
            int collums = cartRepository.updateQuantity(request.quantity(), cart.getId());
            if(collums>0){
            return "success!";
            }else{
                return "an unknow error happen when changing your cart";
            }
        }       
    }

    public List<DetailCart> GetCartItemById(Integer id) {
        List<DetailCart> listCart=cartRepository.getCartByUserId(id);
        // List<DetailCart> newListCart=convertReturnCart(listCart);
        return listCart;
    }


    public int deleteCartById(String userID,String productId) {

        Integer userIdNumb=Integer.parseInt(userID);
        String All= "all";
        int row;
        if(productId.equalsIgnoreCase(All)){
            row= cartRepository.deleteAllById(userID);
        }else{
            row = cartRepository.deleteCartById(userIdNumb,productId);

        }
        return row;
        
    }
    

 
     
     
    
        
    



}
