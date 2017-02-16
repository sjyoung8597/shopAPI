package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.dto.RuleInfoDto;

public class RuleParamCheckBiz implements ICheckParameterBiz{

	private HttpServletRequest request = null;
	
	public RuleInfoDto entity;
	
	public RuleParamCheckBiz(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public boolean checkParam()
	{
		String CustomerValuePersent = request.getParameter("CustomerValuePersent");
		String ShopValuePersent = request.getParameter("ShopValuePersent");
		String LookupPersent = request.getParameter("LookupPersent");
		String LikePersent = request.getParameter("LikePersent");
		String UserAverageScorePersent = request.getParameter("UserAverageScorePersent");
		String NewShopInfoPersent = request.getParameter("NewShopInfoPersent");
		String PromotionYNPersent = request.getParameter("PromotionYNPersent");
		
		if(isNumber(CustomerValuePersent) 
				&& isNumber(ShopValuePersent) 
				&& isNumber(LookupPersent) 
				&& isNumber(LikePersent)
				&& isNumber(UserAverageScorePersent)
				&& isNumber(NewShopInfoPersent)
				&& isNumber(PromotionYNPersent))
		{
			return true;
		}
		
		return false;
	}
	
	private boolean isNumber(String str){
        boolean result = false; 

        try{
            Double.parseDouble(str) ;
            result = true ;
        }catch(Exception e){}
         
         
        return result ;
    }
}
