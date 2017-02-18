package com.tmon.biz.calculation;

public abstract class ACalculatorBiz {
	
	public abstract int getResultScore();
	
	public int getCalculationResult()
	{
		return getResultScore();
	}
}
