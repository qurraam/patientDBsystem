package com.hospital.patient.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hospital.patient.common.AccessDeniedException;
import com.hospital.patient.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;
    private List<String> invalidatedTokens = new ArrayList<>(); // list of invalidated tokens


    public String generateJwt(User user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("role", user.getRole());
        claims.put("username", user.getUsername());
        claims.put("employee", user.getEmployee());


        // generate jwt using claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }
    public void invalidateJwt(String token) {
        invalidatedTokens.add(token); // add token to invalidated tokens list
    }

    public boolean isTokenInvalidated(String token) {
        return invalidatedTokens.contains(token); // check if token is present in invalidated tokens list
    }
    



}
