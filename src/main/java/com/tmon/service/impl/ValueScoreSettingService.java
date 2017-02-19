package com.tmon.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.IRuleInfoBiz;
import com.tmon.biz.ISettingBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.impl.RuleInfoBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.biz.impl.ValueScoreBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;
import com.tmon.service.ISettingService;

public class ValueScoreSettingService implements ISettingService {
	
	private HttpServletRequest request = null;
	
	public ValueScoreSettingService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	@Override
	public boolean settingService() {
		
		boolean result = false;
		
		List<ShopInfoDto> list = null;
		RuleInfoDto rule = null;
		
		IShopListBiz listBiz = new ShopListBiz(this.request);
		list = listBiz.getShopList();
		
		IRuleInfoBiz ruleBiz = new RuleInfoBiz(this.request);
		rule = ruleBiz.getRuleInfo();
		
		ISettingBiz settingBiz = new ValueScoreBiz(this.request, list, rule);
		result = settingBiz.setting();
		
		return result;
	}
}
