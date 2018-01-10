package com.gl.allcube.scheduler.test.timer;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class MsgPrinterScheduler {
	private static final Logger logger = LoggerFactory.getLogger(MsgPrinterScheduler.class);
	private AtomicInteger count = new AtomicInteger();
	
	private MsgPrinter msgPrinter;
	
	@PostConstruct
	public void afterPropertiesSet() {
		logger.debug("afterPropertiesSet");
	}
	
	@Scheduled(cron="0/2 * * * * ?")
	public void triggerMsgPrinter() {
		logger.debug("start triggerMsgPrinter");
		int i = count.getAndIncrement();
		logger.debug(String.valueOf(i));
		String msg = "hi"+i;
		msgPrinter.printMsg(msg,i);
		logger.debug("end triggerMsgPrinter");
	}

	public void setMsgPrinter(MsgPrinter msgPrinter) {
		this.msgPrinter = msgPrinter;
	}
	
	
}
