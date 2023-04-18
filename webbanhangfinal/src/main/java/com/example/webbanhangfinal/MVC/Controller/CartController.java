package com.example.webbanhangfinal.MVC.Controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.webbanhangfinal.CartManager.addRequest;
import com.example.webbanhangfinal.CartManager.changeRequest;
import com.example.webbanhangfinal.MVC.Service.CartService;
import com.example.webbanhangfinal.Repository.DetailCart;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    
    @GetMapping("/count")
    public ResponseEntity<Integer> countItem (@RequestParam(name = "userId") String id){
        Integer uid= Integer.parseInt(id);
        return ResponseEntity.ok().body(cartService.getCountItemByUserId(uid)) ;
    }


    @PostMapping("/addToCart")
    public ResponseEntity<Integer> addtoCart(@RequestBody addRequest request){
        return ResponseEntity.ok().body( cartService.addCartFromRequest(request));
    }
    @PostMapping("/changeItem")
    public ResponseEntity<changeRequest> changeCart(@RequestBody changeRequest request){
        String result=cartService.changeQuantity(request);
        switch (result) {
            case "bad request~":
                return ResponseEntity.badRequest().body(request);
            case "an unknow error happen when changing your cart":
                return ResponseEntity.internalServerError().body(request);    
        
            default:
                return ResponseEntity.ok().body(request);
        }      
    }
    @GetMapping("/getCartItem/{id}")
    public ResponseEntity<List<DetailCart>> getCartFromUserId(@PathVariable("id") Integer id){
        List<DetailCart> listItem= cartService.GetCartItemById(id);
        return ResponseEntity.ok(listItem);
    }

    @PostMapping("/save-image")
public ResponseEntity<String> saveImage(@RequestBody String jpgUrl) {
    try {

        String base64String = jpgUrl;
        // remove data URI prefix
        String base64Data = base64String.split(",")[1];
        int length1= base64Data.length();
        System.out.println("length 1 is:" +length1);
        base64Data = base64Data.substring(0, base64Data.length() - 2);
          byte[] imageData = Base64.getDecoder().decode(base64Data);
        // create a unique file name
        String fileName = "invoice-" + System.currentTimeMillis() + ".jpg";
        Path directoryPath = Paths.get("webbanhangfinal/src/main/resources/static/invoice/");
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        File file = new File("webbanhangfinal/src/main/resources/static/invoice/"+fileName);

        file.createNewFile();

        // write the image data to a file on the server        
        Path filePath = Paths.get("webbanhangfinal/src/main/resources/static/invoice/" + fileName); 
  

        


        Files.write(filePath, imageData);        
        // return a success response
        return ResponseEntity.ok("Image saved successfully!");
    }     
    catch (Exception e) {
        // handle any errors
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving image2: " + e.getMessage());
    }
}
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Integer> deleteById(@PathVariable("userId") String userId,@RequestParam(name = "productId") String productId ){
        int result= cartService.deleteCartById(userId,productId);
        if(result>0){
            return ResponseEntity.ok().body(result);
        }else{
            return ResponseEntity.internalServerError().body(result);
        }
    }
}
