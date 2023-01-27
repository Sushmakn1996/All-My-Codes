package com.te.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.users.Role;
import com.te.users.User;

import io.jsonwebtoken.Claims;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.err.println("request entering to filter");
		String header = request.getHeader("Authorization");
		System.err.println("Authorization Header :" + header);

		if (!hasAuthorizationHeader(request)) {
			filterChain.doFilter(request, response);
			System.err.println("filter---login end : "+filterChain);
			return;
			
		}
		String accessToken = getAccessToken(request);
		System.err.println("accessToken : "+accessToken);

		if (!jwtTokenUtil.validateAccessToken(accessToken)) {
			System.err.println("inside if block");
			filterChain.doFilter(request, response);
			return;
		}
		setAuthenticationContext(accessToken, request);
		filterChain.doFilter(request, response);

	}

	private void setAuthenticationContext(String accessToken, HttpServletRequest request) {

		UserDetails userDetails = getUserDetails(accessToken);
		System.err.println("userDetails : " +userDetails);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		System.err.println("authentication : " +authentication);

		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private UserDetails getUserDetails(String accessToken) {
		User user = new User();
		Claims claims = jwtTokenUtil.parseClaims(accessToken);

		String claimRoles = (String) claims.get("roles");
		System.err.println("claimRoles : "+claimRoles);

		claimRoles = claimRoles.replace("[", " ").replace(" ", "]");
		String[] roleNames = claimRoles.split(",");

		for (String aRoleName : roleNames) {
			user.addRole(new Role(aRoleName));
		}

		String subject = (String) claims.get(Claims.SUBJECT);
		System.err.println("subject : "+subject);

		String[] strings = subject.split(",");
		System.err.println("email : "+strings[1]);

		user.setId(Integer.parseInt(strings[0]));
		user.setEmail(strings[1]);
		System.err.println("get user detail---user: "+user);
		return user;
	}

	private boolean hasAuthorizationHeader(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		System.out.println("has authorization Header :" + header);
		if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}
		return true;
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		System.out.println("Token: " + token);
		return token;
	}
}
