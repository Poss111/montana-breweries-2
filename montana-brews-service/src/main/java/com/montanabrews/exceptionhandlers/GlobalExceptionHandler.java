package com.montanabrews.exceptionhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<Object> globalHandler(Exception ex, WebRequest request) {
		LOG.error("Exception caught from Controller '{}' from request '{}'", ex.getMessage(), request);
		LOG.error("Exeption Stacktrace :: ", ex);

		return handleExceptionInternal(ex, "Someting went wrong...", new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
}
