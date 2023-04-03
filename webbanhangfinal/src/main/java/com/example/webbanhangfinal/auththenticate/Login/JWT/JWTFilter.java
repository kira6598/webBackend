package com.example.webbanhangfinal.auththenticate.Login.JWT;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.webbanhangfinal.MVC.Service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter{
private final JWTService jwtService;
private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        final String email;
        final String JWTToken;
        if(authHeader==null||!authHeader.startsWith("Bearer")){
          // các requet đầu tiên(không có JWT token) sẽ lọt vào đây
            filterChain.doFilter(request, response);
            return;
        }
        JWTToken =authHeader.substring(7);
        email= jwtService.extractUsername(JWTToken);

        if(email!=null&&SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            if(jwtService.isTokenValid(JWTToken,userDetails)){
                UsernamePasswordAuthenticationToken authtoken= 
                new UsernamePasswordAuthenticationToken(
                userDetails, 
                null,
                userDetails.getAuthorities());
                authtoken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authtoken);
            }
        }
        filterChain.doFilter(request, response);

        
        
    }

 
    
    
}
