package com.tmon.biz.calculation.detail;

import com.tmon.biz.common.UtilBiz;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class NewShopInfoCalculatorBiz extends AReceiveDecoratorBiz{

	private ASubCalculatorBiz calculator;
	private int value;
	private int persent;
	
	public NewShopInfoCalculatorBiz(ASubCalculatorBiz calculator)
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
		int afterDays = UtilBiz.CurrentDateToInt() - this.calculator.getShopInfo().getN4ModifyDate();
		
		int score = 0;
		
		if(afterDays > 7)
			score = 1;
		else if(afterDays >= 2 && afterDays <= 7)
			score = 2;
		else
			score = 3;
		
		return (score * this.calculator.getRuleInfo().getN4NewShopInfoPersent()) + this.calculator.calculator();
	}
}