package com.gl.allcube.scheduler.test.timer;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gl.allcube.scheduler.test.timer.config.ScheduleAppConfig;

public class SchedulerTest {

	@Test
	public void testScheduler() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ScheduleAppConfig.class);
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
