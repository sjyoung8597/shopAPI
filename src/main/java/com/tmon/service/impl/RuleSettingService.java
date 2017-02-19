package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.*;
import com.tmon.biz.check.RuleParamCheckBiz;
import com.tmon.biz.impl.*;
import com.tmon.dto.RuleInfoDto;
import com.tmon.service.ISettingService;

public class RuleSettingService implements ISettingService {
	
	private HttpServletRequest request = null;
	
	public RuleSettingService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	@Override
	public boolean settingService()
	{
		boolean reuslt = false;
		ICheckParameterBiz check = new RuleParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			ISettingBiz biz = new RuleSettingBiz(addRequestEntity());
			reuslt = biz.setting();
		}
		
		return reuslt;
	}
	
	public RuleInfoDto addRequestEntity()
	{
		RuleInfoDto entity = new RuleInfoDto(Integer.parseInt(request.getParameter("CustomerValuePersent")),
				Integer.parseInt(request.getParameter("ShopValuePersent")),
				Integer.parseInt(request.getParameter("LookupPersent")),
				Integer.parseInt(request.getParameter("LikePersent")),
				Integer.parseInt(request.getParameter("UserAverageScorePersent")),
				Integer.parseInt(request.getParameter("NewShopInfoPersent")),
				Integer.parseInt(request.getParameter("PromotionYNPersent")),
				request.getSession().getServletContext().getRealPath("\\"));
		
		return entity;
	}
}
