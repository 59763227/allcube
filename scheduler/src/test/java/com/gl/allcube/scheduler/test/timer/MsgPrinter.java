package com.gl.allcube.scheduler.test.timer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.gl.allcube.scheduler.common.util.DatetimeUtils;

public class MsgPrinter {
	private static final Logger logger = LoggerFactory.getLogger(MsgPrinter.class);

	@Async
	public void printMsg(String msg,int seconds) {
		String threadName = Thread.currentThread().getName();
		String datetime = DatetimeUtils.datetime2str(new Date());
		logger.info(threadName+"-"+datetime + "-" + msg);
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
