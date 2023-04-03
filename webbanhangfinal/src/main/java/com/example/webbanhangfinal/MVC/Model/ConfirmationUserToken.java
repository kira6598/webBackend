package com.example.webbanhangfinal.MVC.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "enable_user_token")
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationUserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime ExpridateAt;
  
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private AppUser appUser;

    public ConfirmationUserToken( String token, LocalDateTime createdAt, LocalDateTime expridateAt,
    AppUser appUser) {            
        this.token = token;
        this.createdAt = createdAt;
        this.ExpridateAt = expridateAt;
        this.appUser = appUser;
        }

}
