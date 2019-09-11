package com.aks.security;

import com.aks.POJO.UserPojo;
import com.aks.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(UserPojo user) {

//        Claims cl=Jwts.builder().setExpiration()

        Claims claims = Jwts.claims()
                .setSubject(user.getEmail());
        claims.put("userId", String.valueOf(user.getId()));
//        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
