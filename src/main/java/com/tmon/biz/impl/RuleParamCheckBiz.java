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
		String CustomerValuePersent = this.request.getParameter("CustomerValuePersent");
		String ShopValuePersent = this.request.getParameter("ShopValuePersent");
		String LookupPersent = this.request.getParameter("LookupPersent");
		String LikePersent = this.request.getParameter("LikePersent");
		String UserAverageScorePersent = this.request.getParameter("UserAverageScorePersent");
		String NewShopInfoPersent = this.request.getParameter("NewShopInfoPersent");
		String PromotionYNPersent = this.request.getParameter("PromotionYNPersent");
		
		if(UtilBiz.isNumber(CustomerValuePersent) 
				&& UtilBiz.isNumber(ShopValuePersent) 
				&& UtilBiz.isNumber(LookupPersent) 
				&& UtilBiz.isNumber(LikePersent)
				&& UtilBiz.isNumber(UserAverageScorePersent)
				&& UtilBiz.isNumber(NewShopInfoPersent)
				&& UtilBiz.isNumber(PromotionYNPersent))
		{
			//sum result 100% check logic insert
			//if((Integer.parseInt(CustomerValuePersent) + Integer.parseInt(ShopValuePersent)) == 100)
			//...........
			return true;
		}
		
		return false;
	}
}
