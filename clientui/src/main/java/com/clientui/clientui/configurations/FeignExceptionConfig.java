package com.clientui.clientui.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clientui.clientui.exceptions.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {

	@Bean
	public CustomErrorDecoder mCustomErrorDecoder() {
		return new CustomErrorDecoder();
	}
}
