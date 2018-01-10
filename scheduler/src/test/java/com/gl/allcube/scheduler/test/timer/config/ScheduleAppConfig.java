package com.gl.allcube.scheduler.test.timer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.gl.allcube.scheduler.test.timer.MsgPrinter;
import com.gl.allcube.scheduler.test.timer.MsgPrinterScheduler;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleAppConfig {
	
	@Bean
	public MsgPrinter getMsgPrinter() {
		return new MsgPrinter();
	}
	
	@Bean
	public MsgPrinterScheduler getMsgPrinterScheduler() {
		MsgPrinterScheduler sch =  new MsgPrinterScheduler();
		sch.setMsgPrinter(getMsgPrinter());
		return sch;
	}
}
