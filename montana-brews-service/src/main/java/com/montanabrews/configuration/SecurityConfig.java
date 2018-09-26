package com.montanabrews.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import com.montanabrews.authentication.CustomAccessDeniedHandler;
import com.montanabrews.authentication.RestAuthenticationEntryPoint;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		LOG.info("hit Auth configure");
//		UserBuilder user = User.withDefaultPasswordEncoder();
//		user.username("temp");
//		user.password("temp");
//		user.roles("WRITE");
//		UserDetails userd = user.build();
//		LOG.info(userd.getUsername() + " " + userd.getPassword());
//		auth.inMemoryAuthentication().withUser(user.build());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOG.info("hit auth http configure");
		http.antMatcher("/private/**").authorizeRequests().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().and().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).accessDeniedHandler(customAccessDeniedHandler)
				.and().csrf().disable();
	}

}
