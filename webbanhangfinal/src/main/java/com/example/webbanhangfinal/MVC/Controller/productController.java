package com.example.webbanhangfinal.MVC.Controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.webbanhangfinal.MVC.Model.ProductModel;
import com.example.webbanhangfinal.MVC.Service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class productController {
    private final ProductService productService;
    @GetMapping("/count")
    public Integer getEntity(){
        return productService.getCount();
    }

    @PostMapping("/addData")
    public ResponseEntity<String> getData(@RequestBody ProductModel product){
        String id = product.getId();
        if(id!=null){
            
            productService.addProduct(product);
        }else{
            return ResponseEntity.badRequest().body("Failed!"+id);
        }
        return ResponseEntity.ok("Success~"+id);
    }
    @GetMapping("/searchProduct")
    public ResponseEntity<List<ProductModel>> getProductByName(@RequestParam(name = "productName") String name){
        if(name==null){
            return null;
        }else{
            return ResponseEntity.ok(productService.getProductByName(name));
        }
            
    }
  
}
