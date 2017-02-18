package com.tmon.biz.calculation.detail;

public class PromotionCalculatorBiz extends ASubCalculatorBiz{

	private ASubCalculatorBiz calculator;

	public PromotionCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
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