package com.tmon.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.IRuleInfoBiz;
import com.tmon.biz.ISettingBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.impl.RuleInfoBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.biz.impl.ValueScoreBiz;
import com.tmon.dto.ResponseCodeDto;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;
import com.tmon.service.ISettingService;

public class ValueScoreSettingService implements ISettingService {
	
	private String savePath;
	
	public ValueScoreSettingService(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
	}
	
	@Override
	public ResponseCodeDto settingService() {
		
		ResponseCodeDto result = null;
		
		List<ShopInfoDto> list = null;
		RuleInfoDto rule = null;
		
		IShopListBiz listBiz = new ShopListBiz(this.savePath);
		list = listBiz.getShopList();
		
		IRuleInfoBiz ruleBiz = new RuleInfoBiz(this.savePath);
		rule = ruleBiz.getRuleInfo();
		
		ISettingBiz settingBiz = new ValueScoreBiz(this.savePath, list, rule);
		result = settingBiz.setting();

		return result;
	}
}
