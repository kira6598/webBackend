// package com.example.webbanhangfinal;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyInt;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.when;

// import java.util.Optional;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInstance;
// import org.junit.jupiter.api.TestInstance.Lifecycle;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.example.webbanhangfinal.CartManager.CartRespone;
// import com.example.webbanhangfinal.CartManager.addRequest;
// import com.example.webbanhangfinal.CartManager.changeRequest;
// import com.example.webbanhangfinal.MVC.Model.Cart;
// import com.example.webbanhangfinal.MVC.Model.AppUser;
// import com.example.webbanhangfinal.MVC.Model.ProductModel;
// import com.example.webbanhangfinal.MVC.Service.CartService;
// import com.example.webbanhangfinal.MVC.Service.ProductService;
// import com.example.webbanhangfinal.MVC.Service.UserService;
// import com.example.webbanhangfinal.Repository.CartRepository;
// import com.example.webbanhangfinal.Repository.UserRepository;
// import com.example.webbanhangfinal.Repository.ProductRepository;

// // @SpringBootTest
// // @TestInstance(Lifecycle.PER_CLASS)
// @TestInstance(value = Lifecycle.PER_CLASS)

// class WebbanhangfinalApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// 	@Mock
// 	private  CartRepository cartRepository;
// 	@Mock
// 	private ProductRepository productRepository;
// 	@Mock
// 	private UserRepository userRepository;


// 	private ProductService productService;
// 	private UserService userService;
// 	private  CartService cartService;
// 	private AutoCloseable autoCloseable;

// 	@BeforeEach
	
// 	public void setup(){
// 		autoCloseable =MockitoAnnotations.openMocks(this);
// 		productService= new ProductService(productRepository);
// 		userService = new UserService(userRepository, null, null);
// 		cartService = new CartService(cartRepository, userService, productService);
// 		Integer userId=1;
// 		AppUser user = new AppUser();
// 		user.setId(userId);
// 		user.setFirstname("son");
// 		ProductModel productModel= new ProductModel();
// 		productModel.setId("1");
// 		productModel.setProductName("sp1");	
// 		Cart cart = new Cart();
// 		cart.setId(1);
// 		cart.setProduct(productModel);
// 		cart.setClient(user);

// 		AppUser user2 = new AppUser();
// 		user2.setId(2);
// 		user2.setFirstname("mai");
// 		ProductModel productModel2= new ProductModel();
// 		productModel2.setId("2");
// 		productModel2.setProductName("sp2");
// 		Cart cart2 = new Cart();
// 		cart2.setProduct(productModel2);
// 		cart2.setClient(user2);
// 		cart2.setQuantity(1);

// 		Cart saveCart = new Cart();
// 		saveCart.setId(2);
// 		saveCart.setProduct(productModel2);
// 		saveCart.setClient(user2);
// 		saveCart.setQuantity(1);
		
// 		Optional<ProductModel> productOP2=Optional.of(productModel2); 
// 		Optional<AppUser> userOP2= Optional.of(user2); 
// 		when(cartRepository.getCart(1, "1")).thenReturn(cart);
// 		when(cartRepository.getCart(3, "3")).thenReturn(cart2);
// 		when(cartRepository.getCart(2, "2")).thenReturn(null);
// 		when(cartRepository.updateQuantity(anyInt(),eq(1))).thenReturn(1);
// 		when(cartRepository.updateQuantity(anyInt(),eq(2))).thenReturn(0);
// 		when(cartRepository.save(any(Cart.class))).thenReturn(saveCart);

// 		when(userService.getUserById(2)).thenReturn(userOP2);
// 		when(productService.getProductById("2")).thenReturn(productOP2);


// 	}
	

// 	@AfterEach
// 	void closeService() throws Exception {
//         autoCloseable.close();
//     }
// 	// @Test
// 	// public void cartServiceIfExistEntity(){
// 	// 	addRequest addRequest1= new addRequest(1, "1");
// 	// 	CartRespone respone= cartService.addCartFromRequest(addRequest1);	
// 	// 	assertEquals(null, respone);
// 	// }
// 	// @Test
// 	// public void cartServiceIfNotExistEntity(){
// 	// 	addRequest addRequest2= new addRequest(2, "2");
// 	// 	CartRespone respone= cartService.addCartFromRequest(addRequest2);
// 	// 	AppUser user = new AppUser();
// 	// 	user.setId(2);
// 	// 	user.setFirstname("mai");
// 	// 	ProductModel productModel= new ProductModel();
// 	// 	productModel.setId("2");
// 	// 	productModel.setProductName("sp2");

// 	// 	Cart cart = new Cart();
// 	// 	cart.setId(2);
// 	// 	cart.setProduct(productModel);
// 	// 	cart.setClient(user);
// 	// 	cart.setQuantity(1);
// 	// 	cartRepository.save(cart);
// 	// 	CartRespone expect = new CartRespone(cart.getProduct().getId(), cart.getQuantity(), cart.getId());
// 	// 	assertEquals(expect, respone);
// 	// }

// 	// @Test
// 	// public void changeQuantityCartService(){
// 	// 	changeRequest request1ChangeRequest = new changeRequest(1, "1", 2);
// 	// 	String result= cartService.changeQuantity(request1ChangeRequest);
// 	// 	assertEquals("success!", result);

// 	// 	changeRequest request2ChangeRequest = new changeRequest(2, "2", 2);
// 	// 	String result2= cartService.changeQuantity(request2ChangeRequest);
// 	// 	assertEquals("bad request", result2);


// 	// 	changeRequest request3ChangeRequest = new changeRequest(3, "3", 2);
// 	// 	String result3= cartService.changeQuantity(request3ChangeRequest);
// 	// 	assertEquals("an unknow error happen when changing your cart", result3);
// 	// }

// }




	


	
	

