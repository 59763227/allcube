package com.gl.allcube.cube.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeEchoController {
	private static final Logger log = LoggerFactory.getLogger(DateTimeEchoController.class);
	
	@GetMapping("/datetime/echo")
	public String getDateTimeEcho(@RequestParam("user") String username){
		log.info("step into getDateTimeEcho,username={}",username);
		
		String dateTimeEcho = buildDateTimeEcho(username);
		
		log.info("step out getDateTimeEcho,dateTimeEcho={}",dateTimeEcho);
		
		return dateTimeEcho;
	}
	
	private String buildDateTimeEcho(String username){
		Date now = new Date();
		
		
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String nowStr = df.format(now);
		
		return String.format("hi,%s,current datetime is %s", username,nowStr);
	}
}
