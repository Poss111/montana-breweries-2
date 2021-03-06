package com.montanabrews.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.SessionManagementFilter;

import com.montanabrews.authentication.CorsFilterHandler;
import com.montanabrews.authentication.CustomAccessDeniedHandler;
import com.montanabrews.authentication.RestAuthenticationEntryPoint;
import com.montanabrews.constants.MontanaBrewsAPIConstants;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;

	@Autowired
	private CorsFilterHandler corsFilterHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilterHandler, SessionManagementFilter.class)
				.antMatcher(MontanaBrewsAPIConstants.PRIVATE_API_FILTER).authorizeRequests().anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.httpBasic().and().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
				.accessDeniedHandler(customAccessDeniedHandler).and().csrf().disable();
	}

}
