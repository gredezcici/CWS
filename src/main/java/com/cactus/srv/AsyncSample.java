package com.cactus.srv;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class AsyncSample {
	@Async
	public void asyncMethodWithVoidReturnType() {
		System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
	}

	@Async
	public Future<String> asyncMethodWithReturnType() {
		System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			return new AsyncResult<String>("hello world !!!!");
		} catch (InterruptedException e) {
			//
		}

		return null;
	}

}
