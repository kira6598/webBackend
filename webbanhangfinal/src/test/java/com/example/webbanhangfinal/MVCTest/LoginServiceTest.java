// package com.example.webbanhangfinal.MVCTest;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.example.webbanhangfinal.MVC.Model.AppUser;
// import com.example.webbanhangfinal.MVC.Model.Cart;
// import com.example.webbanhangfinal.MVC.Model.ProductModel;
// import com.example.webbanhangfinal.MVC.Model.ReturnCart;
// import com.example.webbanhangfinal.MVC.Service.CartService;
// import com.example.webbanhangfinal.MVC.Service.ProductService;
// import com.example.webbanhangfinal.Repository.CartRepository;

// public class LoginServiceTest{
//     @Mock
//     private CartRepository cartRepository;

//     private AutoCloseable closeable;

//     private CartService cartService;
//     private ProductService productService;

//     @BeforeEach
//     public void setup(){
//         closeable = MockitoAnnotations.openMocks(this);
//         cartService= new CartService(cartRepository, null, productService);
//     }

//     @AfterEach
//     public void destroy() throws Exception{
//         closeable.close();
//     }

//     @Test
//     public void testConverter(){
//         List<ReturnCart> expect= new ArrayList<>();
//         ReturnCart car1= new ReturnCart(1, "1", 1);
//         ReturnCart car2= new ReturnCart(2, "2", 1);
//         expect.add(car1);expect.add(car2);

//         List<Cart> input = new ArrayList<>();
//         AppUser user1= new AppUser();user1.setId(1);
//         ProductModel product1= new ProductModel();product1.setId("1");
//         ProductModel product2= new ProductModel();product2.setId("2");
//         Cart cart1 = new Cart();cart1.setId(1);cart1.setClient(user1);cart1.setProduct(product1);cart1.setQuantity(1);
//         Cart cart2 = new Cart();cart2.setId(2);cart2.setClient(user1);cart2.setProduct(product2);cart2.setQuantity(1);

//         input.add(cart1);input.add(cart2);

//         assertEquals(expect, cartService.convertReturnCart(input));




//     }



// }