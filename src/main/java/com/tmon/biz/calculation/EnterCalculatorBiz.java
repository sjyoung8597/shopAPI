package com.tmon.biz.calculation;

import com.tmon.biz.IEnterCalculatorBiz;
import com.tmon.biz.calculation.detail.*;
import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class EnterCalculatorBiz implements IEnterCalculatorBiz{
	
	private ShopInfoDto shopInfo;
	private RuleInfoDto ruleInfo;
	
	private int resultScore;
	
	public EnterCalculatorBiz(ShopInfoDto shopInfo, RuleInfoDto ruleInfo)
	{
		this.shopInfo = shopInfo;
		this.ruleInfo = ruleInfo;
		
		process();
	}
	
	public void process()
	{
		ASubCalculatorBiz shopValueCalculator = new ShopCalculatorBiz(this.shopInfo, this.ruleInfo);
		shopValueCalculator = new NewShopInfoCalculatorBiz(shopValueCalculator);
		shopValueCalculator = new PromotionCalculatorBiz(shopValueCalculator);
		
		int shopValueScore = shopValueCalculator.calculator() * this.ruleInfo.getN4ShopValuePersent();
		
		ASubCalculatorBiz customerValueCalculator = new CustomerCalculatorBiz(this.shopInfo, this.ruleInfo);
		customerValueCalculator = new LookupCalculatorBiz(customerValueCalculator);
		customerValueCalculator = new LikeCalculatorBiz(customerValueCalculator);
		customerValueCalculator = new UserAverageScoreCalculatorBiz(customerValueCalculator);
		
		int customerValueScore = customerValueCalculator.calculator() * this.ruleInfo.getN4ShopValuePersent();
		
		this.resultScore = shopValueScore + customerValueScore;
	}
	
	@Override
	public ACalculatorBiz createResult() {
		return new ResultScoreBiz(this.resultScore);
	}
}
