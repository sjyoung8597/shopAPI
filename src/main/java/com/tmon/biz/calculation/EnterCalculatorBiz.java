package com.tmon.biz.calculation;

import com.tmon.biz.IEnterCalculatorBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class EnterCalculatorBiz implements IEnterCalculatorBiz{
	
	private ShopInfoDto shopInfo;
	private RuleInfoDto ruleInfo;
	
	public EnterCalculatorBiz(ShopInfoDto shopInfo, RuleInfoDto ruleInfo)
	{
		this.shopInfo = shopInfo;
		this.ruleInfo = ruleInfo;
	}

	@Override
	public int allSumResultScore() {
		
		return 0;
	}
	
}
