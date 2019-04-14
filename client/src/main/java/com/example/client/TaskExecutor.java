package com.example.client;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@ComponentScan(basePackages = "com.example.client")
public class TaskExecutor {
	
	
	@Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {
        System.out.println("Current date is --->"+ new Date());
    }

}
