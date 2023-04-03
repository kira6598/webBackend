package com.example.webbanhangfinal.MVC.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class ReturnCart {
    String id;
    String productName;
    Integer quantity;
    Integer price;
    Integer total;
    String img; 
}
