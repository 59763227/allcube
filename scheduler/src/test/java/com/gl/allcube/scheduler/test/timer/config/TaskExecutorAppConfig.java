package com.gl.allcube.scheduler.test.timer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorAppConfig {

	@Bean(name="simpleAsyncTaskExecutor")
	public TaskExecutor getSimpleAsyncTaskExecutor() {
		SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("Simple-Test");
		executor.setConcurrencyLimit(6);
		
		
		return executor;
	}
	
	@Bean(name="threadPoolTaskExecutor")
	public TaskExecutor getThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(3);
		executor.setAwaitTerminationSeconds(2);
//		executor.setAllowCoreThreadTimeOut(true);
		executor.setQueueCapacity(3);
		return executor;
	}
}
