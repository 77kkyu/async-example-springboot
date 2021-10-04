package com.example.asyncexamplespringboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class BasicService {

	@Async
	public void onAsync() {
		try {
			Thread.sleep(5000);
			System.out.println("onAsync");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onSync() {
		try {
			Thread.sleep(5000);
			System.out.println("onSync");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Async
	public Future<String> logger() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("서비스");
		return new AsyncResult<>("결과!!!");
	}

}
