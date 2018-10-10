package com.montanabrews.authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CorsFilterHandler implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(CorsFilterHandler.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		LOG.debug("Setting up CORS filters for requests...");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("Access-Control-Max-Age", "180");
        filterChain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
