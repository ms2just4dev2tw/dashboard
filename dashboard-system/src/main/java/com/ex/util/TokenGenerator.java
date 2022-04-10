package com.ex.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class TokenGenerator {

    private static long lifeTime = 24 * 60 * 60 * 1000;
    private static String signature = "admin";

    public static String generateTokenByJWT() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "jwt").setHeaderParam("alg", "HS256")
                // payload
                .claim("name", "admin").claim("role", "admin")
                //
                .setSubject("admin-token")
                //
                .setExpiration(new Date(System.currentTimeMillis() + lifeTime))
                //
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, signature).compact();
        return jwtToken;
    }

}
