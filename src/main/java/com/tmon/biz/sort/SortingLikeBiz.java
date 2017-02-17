package com.tmon.biz.sort;

import java.util.Comparator;

import com.tmon.biz.impl.UtilBiz;
import com.tmon.dto.ShopInfoDto;

public class SortingLikeBiz implements Comparator<ShopInfoDto>{
	
	private String sort = "asc";
	
	private SortingLikeBiz(String sort)
	{
		this.sort= sort;
	}
	
	@Override
	public int compare(ShopInfoDto o1, ShopInfoDto o2) {
		int firstValue = o1.getN4Like();
		int secondValue = o2.getN4Like();
		
		return UtilBiz.SortUtil(firstValue, secondValue, this.sort);
	}
}
