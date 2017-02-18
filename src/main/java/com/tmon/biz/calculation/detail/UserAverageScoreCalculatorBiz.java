package com.tmon.biz.calculation.detail;

public class UserAverageScoreCalculatorBiz extends ASubCalculatorBiz{

	private ASubCalculatorBiz calculator;
	
	public UserAverageScoreCalculatorBiz(ASubCalculatorBiz calculator)
	{
		this.calculator = calculator;
	}
	
	public int calculator()
	{
		int score = 0;
		
		if(this.calculator.getShopInfo().getN4UserAverageScore() < 5)
			score = 1;
		else if(this.calculator.getShopInfo().getN4UserAverageScore() >= 5 && this.calculator.getShopInfo().getN4UserAverageScore() <= 9)
			score = 2;
		else
			score = 3;
		
		return (score * this.calculator.getRuleInfo().getN4UserAverageScorePersent()) + this.calculator.calculator();
	}
}
