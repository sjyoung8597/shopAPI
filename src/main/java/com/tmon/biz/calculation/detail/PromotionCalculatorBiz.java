package com.tmon.biz.calculation.detail;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class PromotionCalculatorBiz extends AReceiveDecoratorBiz{

	private ASubCalculatorBiz calculator;

	public PromotionCalculatorBiz(ASubCalculatorBiz calculator)
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
		
		if(this.calculator.getShopInfo().getIsShopPromotionYN())
			score = 3;
		else
			score = 0;
			
		return (score * this.calculator.getRuleInfo().getN4PromotionYNPersent()) + this.calculator.calculator();
	}
}