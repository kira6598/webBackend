package com.example.webbanhangfinal.UserCartManager;



import com.example.webbanhangfinal.AppProduct.productModel;
import com.example.webbanhangfinal.auththenticate.UserManagerment.AppUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart1")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private productModel product;
    @ManyToOne
    private  AppUser client;
    private int quantity;

}
