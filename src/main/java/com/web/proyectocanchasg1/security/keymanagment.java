package com.web.proyectocanchasg1.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public final class keymanagment {

    private static String SECRET_KEY;

    private keymanagment(){
        //ignore
    }

    @Value("${jwt.secretKey}")
    public void setSecretKey(String secretKey) {
        keymanagment.SECRET_KEY = secretKey;
    }

    public static String createJWT(String username, String Password){
        Key secret =  Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        long EXPIRATION_TIME = 86400000;
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .addClaims(claims)
                .signWith(secret)
                .compact();
    }

    public static String decodeJWT(String token){
        // Convert the keyString to a Key object
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        // Parse the JWT string and extract the claims
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        // Access the claims
        return claims.getSubject();
    }






}
