package com.everm.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatTest {
	private final static DateFormat DATE_FORMAT_1 = new SimpleDateFormat(
			"EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
	private final static DateFormat DATE_FORMAT_MILLIS = new SimpleDateFormat("yyyy-MM-dd HH:mm s.SSS");
	
	public static long format(String startTime, String endTime) {
		try{
			Date startDate = DATE_FORMAT_MILLIS.parse(startTime);
			Date endDate = DATE_FORMAT_MILLIS.parse(endTime);
			return endDate.getTime() - startDate.getTime();
		} catch (ParseException e){
			e.printStackTrace();
			return 0L;
		}
	}
	
//	public static String getCurrentTimeMillis() {
//		long currentTime = System.currentTimeMillis();
//		Date date = new Date(System.currentTimeMillis);
//		
//		Date d = new Date();
//		
//		return DATE_FORMAT_MILLIS.format(date);
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
//		int n = 0;
//		while(n>100000) {
//			DateFormatTest.format(startTime, endTime);
//		}
		
		//		System.out.println(DATE_FORMAT_MILLIS.format(new Date()));
		//		System.out.println(DATE_FORMAT_MILLIS.format(new Date(System.currentTimeMillis())));

		DATE_FORMAT_1.setTimeZone(TimeZone.getTimeZone("GMT"));
		String date = DATE_FORMAT_1.format(Calendar.getInstance().getTime())
				+ " GMT";
		System.out.println(date);
	}

}
