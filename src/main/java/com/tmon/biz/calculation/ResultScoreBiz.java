package com.tmon.biz.calculation;

public class ResultScoreBiz extends ACalculatorBiz{

	private int resultScore;
	
	public ResultScoreBiz(int resultScore){
		this.resultScore = resultScore;
	}

	@Override
	public int getResultScore() {
		return this.resultScore;
	}
}
