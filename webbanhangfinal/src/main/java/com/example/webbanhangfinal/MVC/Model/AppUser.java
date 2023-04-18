package com.example.webbanhangfinal.MVC.Model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.webbanhangfinal.UserManagerment.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "app_user")
@Setter
@Getter
@NoArgsConstructor

public class AppUser  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    public AppUser(String firstname, String lastname, String email, Role role, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    private boolean enabled=false;
    private Boolean locked=false;

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {    
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        List<? extends GrantedAuthority> list = Collections.singletonList(authority);
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !locked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
}
