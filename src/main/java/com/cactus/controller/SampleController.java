package com.cactus.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cactus.entities.Greeting;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SampleController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static final Logger logger = LogManager.getLogger(SampleController.class);
	@Autowired
	private ObjectMapper objectMapper;
	
	@RequestMapping("/hello/{name}")
	public Greeting home(@PathVariable String name) {
		logger.info("hello "+ objectMapper);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/greetings")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("Greeting");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
