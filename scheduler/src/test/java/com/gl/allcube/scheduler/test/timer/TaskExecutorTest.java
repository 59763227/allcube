package com.gl.allcube.scheduler.test.timer;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskExecutor;

import com.gl.allcube.scheduler.common.util.DatetimeUtils;
import com.gl.allcube.scheduler.test.timer.config.TaskExecutorAppConfig;

public class TaskExecutorTest {
	
	
	@Test
	public void testSimpleAsyncTaskExecutor() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExecutorAppConfig.class);
		TaskExecutor executor = ctx.getBean("simpleAsyncTaskExecutor",TaskExecutor.class);
		
		for(int i=0;i<25; i++) {
			String msg = "hello"+i;
			System.out.println(i);
			executor.execute(new MsgPrinterTask(msg,i));
		}
	}
	
	@Test
	public void testThreadPoolTaskExecutor() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExecutorAppConfig.class);
		TaskExecutor executor = ctx.getBean("threadPoolTaskExecutor",TaskExecutor.class);
		
		for(int i=0;i<25; i++) {
			String msg = "hello"+i;
			System.out.println(i);
			executor.execute(new MsgPrinterTask(msg,i));
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private class MsgPrinterTask implements Runnable{
		private String msg;
		private int seconds;
		
		public MsgPrinterTask(String msg,int seconds) {
			this.msg = msg;
			this.seconds = seconds;
		}
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			String datetime = DatetimeUtils.datetime2str(new Date());
			System.out.println(threadName+"-"+datetime + "-" + msg);
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
