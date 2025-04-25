package tiktok.duong.tiktok_duong.service;


import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String secretKey;

	private long validity = 5; //5 phut
	
	private Key getSignKey() {
	    return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	}
	public String createToken(String username) {
	    Claims claims = Jwts.claims().setSubject(username);
	    Date now = new Date();
	    Date exp = new Date(now.getTime() + validity * 60 * 1000);

	    

	    return Jwts.builder()
	            .setClaims(claims)
	            .setIssuedAt(now)
	            .setExpiration(exp)
	            .signWith(SignatureAlgorithm.HS256, getSignKey())
	            .compact();
	}
	public boolean isValidadToken(String token) {
		try {
		Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token);
		return true;
		}catch(Exception e){
			
		}
		return false;
	}
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token)
				.getBody().getSubject();
	}
}
