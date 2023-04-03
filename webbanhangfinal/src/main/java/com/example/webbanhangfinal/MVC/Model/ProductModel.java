package com.example.webbanhangfinal.MVC.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductModel {
    @Id
    private String id;
    private String image;
    private String productName;
    private int stocked;
    private int price;
   
}
