package com.tmon.biz.calculation.detail;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public abstract class ASubCalculatorBiz {
	
	public ShopInfoDto shopInfo;
	public RuleInfoDto ruleInfo;
	
	public ShopInfoDto getShopInfo()
	{
		return this.shopInfo;
	}
	
	public RuleInfoDto getRuleInfo()
	{
		return this.ruleInfo;
	}
	
	public abstract int calculator();
}
