package com.tmon.biz.sort;

import com.tmon.biz.impl.UtilBiz;
import com.tmon.dto.ShopInfoDto;

public class SortLookupBiz extends SortBiz{
	
	private String sortASC = "asc";
	
	public SortLookupBiz(String sortASC)
	{
		this.sortASC = sortASC;
	}
	
	@Override
	public int compare(ShopInfoDto o1, ShopInfoDto o2) {
		int firstValue = o1.getN4Lookup();
		int secondValue = o2.getN4Lookup();
		
		return UtilBiz.SortUtil(firstValue, secondValue, this.sortASC);
	}
}
