package com.example.demo;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;


@SpringBootApplication
public class ServiceBusQueueMultiBindersApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBusQueueMultiBindersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceBusQueueMultiBindersApplication.class, args);
	}

	@Bean
	public Function<Message<String>, Message<String>> function1() {
		return message -> {
			LOGGER.info("New message1 received: '{}'", message);
			return message;
		};
	}

	@Bean
	public Function<Message<String>, Message<String>> function2() {
		return message -> {
			LOGGER.info("New message2 received: '{}'", message);
			return message;
		};
	}

}