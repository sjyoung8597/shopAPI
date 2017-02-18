package com.tmon.biz.sort;

import java.util.Comparator;

import com.tmon.dto.ShopInfoDto;

public abstract class ASortBiz implements Comparator<ShopInfoDto>{
	
	public int compare(ShopInfoDto o1, ShopInfoDto o2) 
	{
		return 0;
	}
}
