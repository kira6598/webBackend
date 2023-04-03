package com.example.webbanhangfinal.MVC.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";


    public  String generateToken(UserDetails user) {
        return generateToken(new HashMap<>(), user);
    }
    public String generateToken(Map<String,Object> extractClaims,UserDetails userDetails ){
        System.out.println(System.currentTimeMillis());
        return Jwts.builder()
        .setClaims(extractClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
        
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
      }
    public String extractUsername(String jWTToken) {
        return extractClaims(jWTToken,Claims::getSubject);
    }
    private <T> T extractClaims(String jWTToken, Function<Claims,T> ClaimsResolver) {
        final Claims claims = extractAllClaims(jWTToken);
        return ClaimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String jWTToken) {
        return Jwts.parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJwt(jWTToken)
        .getBody();
    }
    public boolean isTokenValid(String jWTToken, UserDetails userDetails) {
        final String username= extractUsername(jWTToken);
        return (username.equals(userDetails.getUsername()))&&!isTokenExpired(jWTToken);
    }
    private boolean isTokenExpired(String jWTToken) {
        return extractExpired(jWTToken).before(new Date());
    }
    private Date extractExpired(String jWTToken) {
        return extractClaims(jWTToken, Claims::getExpiration);
    }
      
    
}
