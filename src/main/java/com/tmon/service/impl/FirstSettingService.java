package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.impl.RuleSettingBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.service.ISettingService;

public class FirstSettingService implements ISettingService {
	
	RuleInfoDto entity = null;
	
	public FirstSettingService(int n4CustomerValuePersent
			, int n4ShopValuePersent
			, int n4LookupPersent
			, int n4LikePersent
			, int n4UserAverageScorePersent
			, int n4NewShopInfoPersent
			, int n4PromotionYNPersent
			, HttpServletRequest request)
	{
		entity = new RuleInfoDto(n4CustomerValuePersent
			, n4ShopValuePersent
			, n4LookupPersent
			, n4LikePersent
			, n4UserAverageScorePersent
			, n4NewShopInfoPersent
			, n4PromotionYNPersent
			, request.getSession().getServletContext().getRealPath("\\"));
	}
	
	@Override
	public boolean settingService()
	{
		boolean result = false;
		ISettingBiz biz = new RuleSettingBiz(this.entity);
		result = biz.setting();
		
		return result;
	}
}
