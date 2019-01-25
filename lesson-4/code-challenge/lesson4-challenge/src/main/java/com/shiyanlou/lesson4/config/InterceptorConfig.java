package com.shiyanlou.lesson4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.shiyanlou.lesson4.interceptor.UserInterceptor;


@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{

	@Autowired
	private UserInterceptor userInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userInterceptor).addPathPatterns("/user/*").excludePathPatterns("/user/login");

        super.addInterceptors(registry);
    }
}


