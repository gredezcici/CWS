package com.cactus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cactus.entities.Greeting;
import com.cactus.exception.UserNotFoundException;

@RestController
public class CactusUserController {
	private static final Logger logger = LogManager.getLogger(SampleController.class);
	@RequestMapping("/Auth/{name}")
	public Greeting validateUser(@PathVariable String name) {
		logger.info("hello");
		throw new UserNotFoundException(name);
	}
}
