package com.gl.allcube.scheduler.test.timer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gl.allcube.scheduler.common.util.DatetimeUtils;

public class MsgPrinterTask implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(MsgPrinterTask.class);
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
		logger.info(threadName+"-"+datetime + "-" + msg);
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
