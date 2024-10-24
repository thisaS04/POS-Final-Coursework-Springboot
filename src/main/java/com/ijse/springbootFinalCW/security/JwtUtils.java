package com.ijse.springbootFinalCW.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.Authentication;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Configuration
public class JwtUtils {
     @Value("${app.secret}")
    private String secret;

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)); //generating key with the secret
    }

    public String generateJwtToken(Authentication authentication) {

        UserDetails user = (UserDetails) authentication.getPrincipal();

        //generate JWT Token from user detail above
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 24)) //expire in 24 hours
                .signWith(SignatureAlgorithm.HS256, key())
                .compact();

    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.builder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String extractUsernameFromJwt(String token) {
        return ((Object) Jwts.builder()).setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject(); //getting username
    }
}
