package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.*;
import com.tmon.biz.impl.*;
import com.tmon.dto.RuleInfoDto;
import com.tmon.service.IRuleSettingService;

public class RuleSettingService implements IRuleSettingService {
	
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
			ISettingBiz biz = new SettingBiz(addEntity());
			reuslt = biz.setting();
		}
		
		return reuslt;
	}
	
	public RuleInfoDto addEntity()
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
