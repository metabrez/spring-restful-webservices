package com.edu.rest.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World ";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {

		return new HelloWorldBean("hello world bean");
	}

	@GetMapping(path = "/hello-world-internationalized")

	public String helloWorldInternationlized(
			@RequestHeader(name = "Accept-Langugage", required = false) Locale locale) {

		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
