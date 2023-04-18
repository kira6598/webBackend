package com.example.webbanhangfinal.MVC.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ProductModel product;
    @ManyToOne
    private  AppUser client;
    private Integer quantity;    
    private Integer total;   
    @Column(columnDefinition = "boolean default false")
    private boolean bought;
}
