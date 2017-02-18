package com.tmon.biz.calculation.detail;

public class LikeCalculatorBiz extends ASubCalculatorBiz{

	private ASubCalculatorBiz calculator;
	
	public LikeCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
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
