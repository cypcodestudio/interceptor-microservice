package com.cypcode.interceptor_microservice.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServiceInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Implement validation logic of your request before it hits the business logic
		log.info("I'm inside preHandle");
		if(request instanceof ContentCachingRequestWrapper) {
			//manipulate custom request DTO
			//check for entity attribute/parameters
			ContentCachingRequestWrapper wrap = (ContentCachingRequestWrapper) request;
			Object dto = wrap.getContentAsString();
			
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Implement validation logic after response is ready to be sent back
		log.info("I'm returning the result: ");
		
		if(response instanceof ContentCachingResponseWrapper) {
			ContentCachingResponseWrapper wresponse = (ContentCachingResponseWrapper) response;
			log.info(new String(wresponse.getContentAsByteArray(), wresponse.getCharacterEncoding()));
		}
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
