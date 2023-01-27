package com.te.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.filter.JwtRequestFilter;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private JwtRequestFilter filter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("authentication manager builder method");
		auth.userDetailsService(detailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("httpsecurity");
		http.csrf().disable().authorizeRequests().antMatchers("/start/register").permitAll()
				.antMatchers("/start/login").hasAnyAuthority("admin").antMatchers("/start/delete").hasAuthority("admin")
				.anyRequest().permitAll().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		log.info("httpsecurity method");
	}

	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
