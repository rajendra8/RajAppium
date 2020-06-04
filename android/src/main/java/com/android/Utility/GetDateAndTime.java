package com.android.Utility;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateAndTime {
	
	
	public static String getDateTime(String arg) {
		if(arg.equals("day")) {
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();	
			System.out.println(dateFormat.format(date));
			return dateFormat.format(arg);
		}else if(arg.equals("date")) {
			DateFormat dateFormat = new SimpleDateFormat("E");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			return dateFormat.format(arg);
		}
		 return arg; 
		
		
	}
}

