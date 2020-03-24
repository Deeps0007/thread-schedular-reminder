package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ReminderClass implements Runnable {

	@Override
	public void run() {
		System.out.println("Task will be executed here...");

	}

}
