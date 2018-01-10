package com.gl.allcube.scheduler.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtils {
	public static final String DEF_DATE_TIME_PATTERN = "yyyyMMddhhmmss";
	public static final String DEF_DATE_TIME_LONG_PATTERN = "yyyyMMddhhmmssSSS";
	public static final String DEF_DATE_PATTERN = "yyyyMMdd";
	public static final String DEF_TIME_PATTERN = "hhmmss";

	public static String datetime2str(Date datetime,String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(datetime);
	}
	
	public static String datetime2str(Date datetime) {
		return datetime2str(datetime,DEF_DATE_TIME_PATTERN);
	}
}
