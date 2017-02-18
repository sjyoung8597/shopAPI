package com.tmon.biz.sort;

import com.tmon.biz.common.UtilBiz;
import com.tmon.dto.ShopInfoDto;

public class SortShopKeyBiz extends ASortBiz{
	
	private String sortASC = "asc";
	
	public SortShopKeyBiz(String sortASC)
	{
		this.sortASC = sortASC;
	}
	
	@Override
	public int compare(ShopInfoDto o1, ShopInfoDto o2) {
		int firstValue = o1.getN4ShopKey();
		int secondValue = o2.getN4ShopKey();
		
		return UtilBiz.SortUtil(firstValue, secondValue, this.sortASC);
	}
}
