package com.tmon.biz.calculation.detail;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class LookupCalculatorBiz extends AReceiveDecoratorBiz{

	private ASubCalculatorBiz calculator;
	
	public LookupCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
	@Override
	public RuleInfoDto getRuleInfo() {
		return this.calculator.getRuleInfo();
	}

	@Override
	public ShopInfoDto getShopInfo() {
		return this.calculator.getShopInfo();
	}
	
	@Override
	public int calculator()
	{
		int score = 0;
		
		if(this.calculator.getShopInfo().getN4Lookup() < 199)
			score = 1;
		else if(this.calculator.getShopInfo().getN4Lookup() >= 199 && this.calculator.getShopInfo().getN4Lookup() <= 999)
			score = 2;
		else
			score = 3;
		
		return (score * this.calculator.getRuleInfo().getN4LookupPersent()) + this.calculator.calculator();
	}
}
