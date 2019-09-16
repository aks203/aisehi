package com.aks.security;

import com.aks.POJO.UserPojo;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates Jwt token against a user for security purposes
 */
@Component
public class JwtGenerator {

    /**
     * @param token
     * @return Expiration Date of token
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * @param token
     * @return Claims extracted from token
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey("youtube")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * @return Current date
     */
    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * @param token
     * @return Is the stored token expired or still valid
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        System.out.println(this.generateCurrentDate());
        return expiration.before(this.generateCurrentDate());
    }

    /**
     * @param user
     * @return generate token for each user who logs in.
     */
    public String generateToken(UserPojo user) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", user.getEmail());
        claims.put("created", this.generateCurrentDate());
        claims.put("userId", String.valueOf(user.getId()));
        return this.generateToken(claims);
    }

    /**
     * puts expiration date and signs the token
     * @param claims
     * @return signed token with expiration date
     */
    private String generateToken(Map<String, Object> claims) {
        long halfAnHour =600000;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + halfAnHour;
        Date exp = new Date(expMillis);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }

}
