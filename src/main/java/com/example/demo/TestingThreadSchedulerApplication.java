package com.example.demo;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestingThreadSchedulerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestingThreadSchedulerApplication.class, args);
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.execute(new ReminderClass());
		scheduler.scheduleAtFixedRate(new ReminderClass(), getTargetHour(17), 1, TimeUnit.MINUTES);
		System.err.println(getTargetHour(17));   // 17 means : 5 pm , you can edit it here..

	}

	private static int getTargetHour(int target) {

		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int currentMinute = (hour * 60) + minute;
		int targetMin = target * 60;
		System.err.println(hour + ":" + minute + "   " + currentMinute + "  " + targetMin);
		return currentMinute < targetMin ? targetMin - currentMinute : targetMin - currentMinute + 1440;
	}
}
