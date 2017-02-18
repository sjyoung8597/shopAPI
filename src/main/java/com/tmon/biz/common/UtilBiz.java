package com.tmon.biz.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.tmon.dto.ShopInfoDto;

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
	
	public static int SortUtil(int firstValue, int secondValue, String sortASC)
	{
		if(sortASC.equals("asc")) //asc
		{
			if(firstValue > secondValue)
				return -1;
			else if(firstValue < secondValue)
				return 1;
			else
				return 0;
		}
		else //desc
		{
			if(firstValue > secondValue)
				return 1;
			else if(firstValue < secondValue)
				return -1;
			else
				return 0;
		}
	}
	
	public static List<ShopInfoDto> PagingShopList(int pageSize, int currentPage, int totalCount, List<ShopInfoDto> list)
	{
		
		if(totalCount < pageSize*(currentPage-1))
		{
			list = null;
		}
		else if(totalCount < (pageSize*currentPage))
		{
			list = list.subList(pageSize*(currentPage-1), totalCount);
		}
		else
		{
			list = list.subList(pageSize*(currentPage-1), pageSize*currentPage);
		}
		
		
		return list;
	}
	
	public static boolean isNumber(String str){
        boolean result = false; 

        try{
            Double.parseDouble(str) ;
            result = true ;
        }catch(Exception e){}
         
         
        return result ;
    }
}
