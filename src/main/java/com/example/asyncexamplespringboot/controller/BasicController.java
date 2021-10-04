package com.example.asyncexamplespringboot.controller;

import com.example.asyncexamplespringboot.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
public class BasicController {

	@Autowired
	private BasicService basicService;

	@GetMapping("/async")
	public String goAsync() {
		basicService.onAsync();
		String str = "Hello Spring Boot Async!!";
		log.info(str);
		return str;
	}

	@GetMapping("/sync")
	public String goSync() {
		basicService.onSync();
		String str = "Hello Spring Boot Sync!!";
		log.info(str);
		return str;
	}

	@GetMapping("/test")
	public String test() throws InterruptedException, ExecutionException {
		Future<String> future = basicService.logger();
		log.info("test 실행!!!!");
		while (true) {
			if(future.isDone()) {
				return future.get();
			}
		}
	}

}
