package com.tmon.biz.calculation;

import com.tmon.biz.calculation.detail.ASubCalculatorBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class ShopMainBiz extends ASubCalculatorBiz  {
	
	public ShopMainBiz(ShopInfoDto shopInfo, RuleInfoDto ruleInfo)
	{
		this.shopInfo = shopInfo;
		this.ruleInfo = ruleInfo;
	}
	
	@Override
	public int calculator() {
		return 0;
	}
}
