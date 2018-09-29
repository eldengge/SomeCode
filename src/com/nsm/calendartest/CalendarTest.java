package com.nsm.calendartest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest{
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)-4);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
	}
}
