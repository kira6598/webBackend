package com.example.webbanhangfinal.SecurityConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.webbanhangfinal.auththenticate.Login.JWT.JWTFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfig {
private final JWTFilter jwtFilter;
private final AuthenticationProvider authenticationProvider;


   
   

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/**").permitAll()
        // .anyRequest().authenticated()
        .and()     
        .headers().frameOptions().sameOrigin()
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
