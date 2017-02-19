package com.tmon.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.calculation.ACalculatorBiz;
import com.tmon.biz.calculation.CalculatorFactoryBiz;
import com.tmon.biz.calculation.EnterCalculatorBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class ValueScoreBiz implements ISettingBiz{
	
	private String savePath = "";
	private List<ShopInfoDto> list;
	private RuleInfoDto rule;
	
	public ValueScoreBiz(HttpServletRequest request, List<ShopInfoDto> list, RuleInfoDto rule)
	{
		this.list = list;
		this.rule = rule;
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
	}
	
	@Override
	public boolean setting()
	{	
		boolean result = false;
		List<ShopInfoDto> setting = new ArrayList<ShopInfoDto>();
		
		for(ShopInfoDto entity : this.list)
		{
			ACalculatorBiz verificationResponse = CalculatorFactoryBiz.getResponse(new EnterCalculatorBiz(entity, this.rule));
			entity.setN4ShopValueScore(verificationResponse.getResultScore());
			
			setting.add(entity);
		}
		
		ISettingBiz settingBiz = new ShopValueSettingBiz(setting, this.savePath);
		result = settingBiz.setting();

		return result;
	}
}
