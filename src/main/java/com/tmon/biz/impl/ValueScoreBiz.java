package com.tmon.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.calculation.ACalculatorBiz;
import com.tmon.biz.calculation.CalculatorFactoryBiz;
import com.tmon.biz.calculation.EnterCalculatorBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class ValueScoreBiz implements ISettingBiz{
	
	private String savePath;
	private List<ShopInfoDto> list;
	private RuleInfoDto rule;
	
	public ValueScoreBiz(String savePath, List<ShopInfoDto> list, RuleInfoDto rule)
	{
		this.list = list;
		this.rule = rule;
		this.savePath = savePath;
	}
	
	@Override
	public boolean setting()
	{	
		boolean result = false;
		List<ShopInfoDto> setting = new ArrayList<ShopInfoDto>();
		
		//가치 산정 로직
		for(ShopInfoDto entity : this.list)
		{
			ACalculatorBiz valueScoreCalculator = CalculatorFactoryBiz.getResponse(new EnterCalculatorBiz(entity, this.rule));
			entity.setN4ShopValueScore(valueScoreCalculator.getResultScore());
			
			setting.add(entity);
		}
		
		//json (DB) update
		ISettingBiz settingBiz = new ShopValueSettingBiz(setting, this.savePath);
		result = settingBiz.setting();

		return result;
	}
}
