package com.example.webbanhangfinal.AppProduct;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class productModel {
    @Id
    private String id;
    private String productName;
    // private int stocked;
    private String price;
   
}
