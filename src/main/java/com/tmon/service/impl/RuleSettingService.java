package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.*;
import com.tmon.biz.check.RuleParamCheckBiz;
import com.tmon.biz.impl.*;
import com.tmon.dto.RuleInfoDto;
import com.tmon.service.ISettingService;

public class RuleSettingService implements ISettingService {
	
	private String savePath;
	private String CustomerValuePersent;
	private String ShopValuePersent;
	private String LookupPersent;
	private String LikePersent;
	private String UserAverageScorePersent;
	private String NewShopInfoPersent;
	private String PromotionYNPersent;
	
	public RuleSettingService(HttpServletRequest request)
	{
		this.CustomerValuePersent = request.getParameter("CustomerValuePersent");
		this.ShopValuePersent = request.getParameter("ShopValuePersent");
		this.LookupPersent = request.getParameter("LookupPersent");
		this.LikePersent = request.getParameter("LikePersent");
		this.UserAverageScorePersent = request.getParameter("UserAverageScorePersent");
		this.NewShopInfoPersent = request.getParameter("NewShopInfoPersent");
		this.PromotionYNPersent = request.getParameter("PromotionYNPersent");
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
	}
	
	@Override
	public boolean settingService()
	{
		boolean reuslt = false;
		ICheckParameterBiz check = new RuleParamCheckBiz(this.CustomerValuePersent, this.ShopValuePersent
				, this.LookupPersent, this.LikePersent
				, this.UserAverageScorePersent, this.NewShopInfoPersent
				, this.PromotionYNPersent);
		
		if(check.checkParam())
		{
			ISettingBiz biz = new RuleSettingBiz(addRequestEntity());
			reuslt = biz.setting();
		}
		
		return reuslt;
	}
	
	public RuleInfoDto addRequestEntity()
	{
		RuleInfoDto entity = new RuleInfoDto(Integer.parseInt(this.CustomerValuePersent),
				Integer.parseInt(this.ShopValuePersent),
				Integer.parseInt(this.LookupPersent),
				Integer.parseInt(this.LikePersent),
				Integer.parseInt(this.UserAverageScorePersent),
				Integer.parseInt(this.NewShopInfoPersent),
				Integer.parseInt(this.PromotionYNPersent),
				this.savePath);
		
		return entity;
	}
}
