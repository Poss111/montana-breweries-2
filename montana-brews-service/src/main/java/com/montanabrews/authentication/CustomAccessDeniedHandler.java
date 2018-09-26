package com.montanabrews.authentication;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, AccessDeniedException accessDeniedExcpetion)
			throws IOException, ServletException {
		LOG.error("Access Denied due to :: " + accessDeniedExcpetion);
		for (String headerName : Collections.list(servletRequest.getHeaderNames())) {
			LOG.info("Header Name : " + headerName + " Header Value : " + servletRequest.getHeaders(headerName).nextElement());
		}
		servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not Authorized");
	}

}
