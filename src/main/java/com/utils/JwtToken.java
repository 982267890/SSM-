package com.utils;

import com.Bean.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
@Component
@Scope("request")
public class JwtToken {
    public  void verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("username").asString());
    }
    public  User verifyTokenUser(String token) {
//        System.out.println(token);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
         try{
             return new User(
             Integer.parseInt(claims.get("id").asString()),
             claims.get("username").asString(),null,
             Integer.parseInt(claims.get("solveNum").asString()),
             Integer.parseInt(claims.get("dayNum").asString()),
             Integer.parseInt(claims.get("ideaNum").asString()));
         }catch (Exception e){
             System.out.println("token错误");
             return null;
         }}
    public  String createToken(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map) //header
                .withClaim("username", user.getUsername()) //payload
                .withClaim("id", String.valueOf(user.getId()))  //id, username, userpwd, solveNum, dayNum, ideaNum
                .withClaim("solveNum",String.valueOf(user.getSolveNum()))
                .withClaim("dayNum",String.valueOf(user.getDayNum()))
                .withClaim("ideaNum",String.valueOf(user.getIdeaNum()))
                .sign(Algorithm.HMAC256("secret")); //加密
        return token;
    }

    public static void main(String[] args) throws Exception {
        User user=new User(10,"sdsd","sdsd",2,3,5);
        JwtToken jwtToken=new JwtToken();
//        System.out.println(jwtToken.createToken(user));
        System.out.println(jwtToken.createToken(user));
        System.out.println(jwtToken.verifyTokenUser("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZGVhTnVtIjoiNSIsInNvbHZlTnVtIjoiMiIsImRheU51bSI6IjMiLCJpZCI6IjEwIiwidXNlcm5hbWUiOiJzZHNkIn0.z5MMVU3UBxafzdYqUuKdftVoBw5q7adQ1cE3GqfQM10"));

    }
}