package com.tmon.biz.sort;

import com.tmon.biz.common.UtilBiz;
import com.tmon.dto.ShopInfoDto;

public class SortShopValueScoreBiz extends SortBiz{

private String sortASC = "asc";
	
	public SortShopValueScoreBiz(String sortASC)
	{
		this.sortASC = sortASC;
	}
	
	@Override
	public int compare(ShopInfoDto o1, ShopInfoDto o2) {
		int firstValue = o1.getN4ShopValueScore();
		int secondValue = o2.getN4ShopValueScore();
		
		return UtilBiz.SortUtil(firstValue, secondValue, this.sortASC);
	}
}
