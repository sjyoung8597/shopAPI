package com.tmon.biz.calculation;

import com.tmon.biz.ICalculatorBiz;

public class CalculatorFactoryBiz {
	public static ACalculatorBiz getResponse(ICalculatorBiz useProcessResult)
	{
		return useProcessResult.createResult();
		
	}
}
