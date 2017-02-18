package com.tmon.biz.calculation.detail;

import com.tmon.dto.RuleInfoDto;
import com.tmon.dto.ShopInfoDto;

public abstract class AReciveDecoratorBiz extends ASubCalculatorBiz {
	
	public abstract RuleInfoDto getRuleInfo();
	public abstract ShopInfoDto getShopInfo();
}
