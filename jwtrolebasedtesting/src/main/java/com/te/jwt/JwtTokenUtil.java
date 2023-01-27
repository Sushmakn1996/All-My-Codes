package com.te.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.te.users.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 10 * 60 * 60 * 1000;  // 10hrs

	@Value("${app.jwt.secret}")
	private String secretKey;

	public String generateAccessToken(User user) {
		System.err.println("generate access token");
		return Jwts.builder().setSubject(user.getId() + "," + user.getEmail())
				.claim("roles", user.getRoles().toString())
				.setIssuer("JWT").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS384, secretKey).compact();

	}

	public boolean validateAccessToken(String token) {
		try {
			System.err.println("validate access token");
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			log.error("Jwt Expired", e);
		} catch (IllegalArgumentException e) {
			log.error("Token is empty", e);
		} catch (MalformedJwtException e) {
			log.error("JWT is invalid", e);
		} catch (UnsupportedJwtException e) {
			log.error("JWT is not Supported", e);
		} catch (SignatureException e) {
			log.error("Signature Validation failed", e);
		}
		return false;
	}
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	
	public Claims parseClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

}
