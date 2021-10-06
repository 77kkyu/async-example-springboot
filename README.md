# Description
- auth : 77kkyu
- development environment : spring-boot
- technology : spring async
---
# Async

- Thread를 이용한 비동기 처리를 @Async어노테이션으로 더 쉽게 수행 가능.
- ThreadPool생성하는 bean생성 후 @Async 어노테이션을 사용하여 비동기 API를 만들 수 있다.

---
# Code

``` java

public class AsyncConfig extends AsyncConfigurerSupport {
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("heowc-async-");
		executor.initialize();
		return super.getAsyncExecutor();
	}
}

```

``` java
@Slf4j
@Service
public class BasicService {

	@Async
	public void onAsync() {
		try {
			Thread.sleep(5000);
			log.info("onAsync");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onSync() {
		try {
			Thread.sleep(5000);
			log.info("onSync");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Async
	public Future<String> logger() throws InterruptedException {
		Thread.sleep(5000);
		log.info("test log");
		return new AsyncResult<>("result!!!");
	}

}
```
