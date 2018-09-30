package com.montanabrews.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger LOG = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest servletRequest, HttpServletResponse servletResponse, AuthenticationException exception)
			throws IOException, ServletException {
		LOG.info("Request :: " + servletRequest.getAuthType());
		LOG.info("Request :: " + servletRequest.getHeader("Authorization"));
		LOG.info("Exception :: " + exception);
		LOG.error("Invalid access attempt to Application...");
		servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not Authorized");
	}

}
