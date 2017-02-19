package com.tmon.biz.calculation.detail;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class LikeCalculatorBiz extends AReceiveDecoratorBiz{

	private ASubCalculatorBiz calculator;
	
	public LikeCalculatorBiz(ASubCalculatorBiz calculator)
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
		
		if(this.calculator.getShopInfo().getN4Like() < 109)
			score = 1;
		else if(this.calculator.getShopInfo().getN4Like() >= 109 && this.calculator.getShopInfo().getN4Like() <= 399)
			score = 2;
		else
			score = 3;
		
		return (score * this.calculator.getRuleInfo().getN4LikePersent()) + this.calculator.calculator();
	}

	
}
