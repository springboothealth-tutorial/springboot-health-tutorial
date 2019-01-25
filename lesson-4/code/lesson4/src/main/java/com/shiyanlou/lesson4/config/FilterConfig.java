package com.shiyanlou.lesson4.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shiyanlou.lesson4.filter.LoginFilter;

@Configuration
public class FilterConfig {

	@Bean
    public FilterRegistrationBean<LoginFilter> registFilter() {
        FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<LoginFilter>();
        
        registration.setFilter(new LoginFilter());
        //
        registration.addInitParameter("exclusions", "/user/login");
        //添加过滤规则
        registration.addUrlPatterns("/*");
        registration.setName("LoginFilter");
        registration.setOrder(1);
        
        return registration;
    }
}
