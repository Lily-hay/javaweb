package com.lily;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    @Test
    public void testGenerateJwt()
    {
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","lily");
        String jwt= Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"lily")//设置算法签名
                .addClaims(claims)//声明有效信息
                .setExpiration(new Date(System.currentTimeMillis()+12*3600*1000))//设置有效时间
                .compact();
        System.out.println(jwt);
        //eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJsaWx5IiwiZXhwIjoxNzUzNDgwNDAwfQ.hJ7CeGI2aQUwVsqgZfKKHPxKfzi9rDf7rs0x3VtiDb8
    }
    @Test
    public void testParseJwt()
    {
        Claims claims=Jwts.parser().setSigningKey("lily")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJsaWx5IiwiZXhwIjoxNzUzNDgwNDAwfQ.hJ7CeGI2aQUwVsqgZfKKHPxKfzi9rDf7rs0x3VtiDb8")
                .getBody();
        System.out.println(claims);
    }

}
