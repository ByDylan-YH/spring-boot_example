package com.bilibili.c_restfulcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class WebRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRestfulApplication.class, args);
	}

	@Bean
	public ViewResolver myViewReolver(){
		return new MyViewResolver();
	}

	public static class MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String viewName, Locale locale) {
			return null;
		}
	}
}
