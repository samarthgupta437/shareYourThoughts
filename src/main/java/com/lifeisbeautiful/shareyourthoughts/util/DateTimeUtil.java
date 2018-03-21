package com.lifeisbeautiful.shareyourthoughts.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static String getCurrentTime() {
		return dateFormat.format(new Date()); //2016/11/16 12:08:43
	}
}
