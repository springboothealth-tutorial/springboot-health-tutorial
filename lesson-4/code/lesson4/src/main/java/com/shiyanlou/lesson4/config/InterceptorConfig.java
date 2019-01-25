package com.shiyanlou.lesson4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.shiyanlou.lesson4.interceptor.WordInterceptor;


@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{

	@Autowired
	private WordInterceptor wordInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(wordInterceptor).addPathPatterns("/user/search");

        super.addInterceptors(registry);
    }
}


