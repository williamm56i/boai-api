package org.boai.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {

    private static SecretKey secretKey;

    public static String generate(String username, Object roleList, long tokenExpireTime) {
        SecretKey secretKey = generalKey();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roleList);
        return Jwts.builder()
                .signWith(secretKey)
                .claims(claims)
                .subject(username)
                .expiration(getExpireDate(tokenExpireTime))
                .compact();
    }

    public static String refresh(String jwt, long tokenExpireTime) {
        Claims claims = parseJwt(jwt);
        if (claims != null && claims.getSubject() != null && claims.get("roles") != null) {
            return generate(claims.getSubject(), claims.get("roles"), tokenExpireTime);
        }
        return null;
    }

    public static Claims parseJwt(String jwt) {
        SecretKey secretKey = generalKey();
        try {
            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(jwt).getPayload();
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private static SecretKey generalKey() {
        if (secretKey == null) {
            secretKey = Keys.hmacShaKeyFor(new byte[32]);
        }
        return secretKey;
    }

    private static Date getExpireDate(long tokenExpireTime) {
        long current = System.currentTimeMillis();
        long exp = current + tokenExpireTime;
        Date expireDate = new Date(exp);
        log.info("expireDate: " + expireDate);
        return expireDate;
    }
}
