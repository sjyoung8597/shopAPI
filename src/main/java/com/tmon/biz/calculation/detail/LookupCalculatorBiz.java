package com.tmon.biz.calculation.detail;

public class LookupCalculatorBiz extends ASubCalculatorBiz{

	private ASubCalculatorBiz calculator;
	
	public LookupCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
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
