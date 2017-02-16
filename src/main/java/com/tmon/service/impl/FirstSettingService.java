package com.tmon.service.impl;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.impl.SettingBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.service.IRuleSettingService;

public class FirstSettingService implements IRuleSettingService {
	
	RuleInfoDto entity = null;
	
	public FirstSettingService(int n4CustomerValuePersent
			, int n4ShopValuePersent
			, int n4LookupPersent
			, int n4LikePersent
			, int n4UserAverageScorePersent
			, int n4NewShopInfoPersent
			, int n4PromotionYNPersent)
	{
		entity = new RuleInfoDto(n4CustomerValuePersent
			, n4ShopValuePersent
			, n4LookupPersent
			, n4LikePersent
			, n4UserAverageScorePersent
			, n4NewShopInfoPersent
			, n4PromotionYNPersent);
	}
	
	@Override
	public boolean settingService()
	{
		boolean result = false;
		ISettingBiz biz = new SettingBiz(this.entity);
		result = biz.setting();
		
		return result;
	}
}
