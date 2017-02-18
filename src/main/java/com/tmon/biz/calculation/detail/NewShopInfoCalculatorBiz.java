package com.tmon.biz.calculation.detail;

public class NewShopInfoCalculatorBiz extends ASubCalculatorBiz{

	private ASubCalculatorBiz calculator;
	private int value;
	private int persent;
	
	public NewShopInfoCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
	public int calculator()
	{
		int score = 0;
		
		if(this.value < 199)
			score = 1;
		else if(this.value > 199 && this.value < 999)
			score = 2;
		else
			score = 3;
		
		return (score * this.calculator.getRuleInfo().getN4NewShopInfoPersent()) + this.calculator.calculator();
	}
}