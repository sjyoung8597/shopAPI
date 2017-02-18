package com.tmon.biz.calculation;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public class ShopCalculatorBiz implements ICalculatorBiz {

	private int resultScore;
	private ShopInfoDto shopInfo;
	private RuleInfoDto ruleInfo;
	
	public ShopCalculatorBiz(ShopInfoDto shopInfo, RuleInfoDto ruleInfo)
	{
		this.shopInfo = shopInfo;
		this.ruleInfo = ruleInfo;
	}

	@Override
	public ACalculatorBiz createResult() {
		return new ResultScoreBiz(this.resultScore);
	}

}
