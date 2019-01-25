package com.shiyanlou.lesson4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shiyanlou.lesson4.listener.OnlineListener;

@Configuration
public class ListenerConfig {
	
	@Bean
	public OnlineListener init() {
		return new OnlineListener();
	}
}
