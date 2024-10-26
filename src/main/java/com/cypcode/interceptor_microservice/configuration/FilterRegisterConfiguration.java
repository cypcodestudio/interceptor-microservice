package com.cypcode.interceptor_microservice.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegisterConfiguration {

	@Bean
	public FilterRegistrationBean<ServiceFilter> filter(){
		FilterRegistrationBean<ServiceFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new ServiceFilter());
		bean.addUrlPatterns("/*");
		
		return bean;
	}
}
