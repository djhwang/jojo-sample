package com.everm.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start..");
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		System.out.println(df.format(new Date()));
		
		System.out.println(ICPS.name);
		
		System.out.println("end..");
		
		System.out.println(TimeUnit.DAYS.toMillis(1));
	}

}
