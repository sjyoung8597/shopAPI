package com.tmon.biz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilBiz {
	
	public static Date StringToDate(String strDate)
	{
		String from = strDate;

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date to = null;
		try {
			to = transFormat.parse(from);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
	public static String DateToString(Date dtDate)
	{
		Date from = new Date();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String to = transFormat.format(from);
		
		return to;

	}
	
	public static int SortUtil(int firstValue, int secondValue, String sort)
	{
		if(sort.equals("asc"))
		{
			if(firstValue > secondValue)
				return -1;
			else if(firstValue < secondValue)
				return 1;
			else
				return 0;
		}
		else
		{
			if(firstValue > secondValue)
				return 0;
			else if(firstValue < secondValue)
				return 1;
			else
				return -1;
		}
	}
}