package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.check.ListParamCheckBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.dto.ShopListDto;
import com.tmon.service.IShopListService;

public class ShopListService implements IShopListService{

private HttpServletRequest request = null;
	
	public ShopListService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public ShopListDto getShopList()
	{
		ShopListDto entity = null;
		ICheckParameterBiz check = new ListParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			IShopListBiz biz = new ShopListBiz(this.request);
			entity = biz.getShopList();
		}
		
		return entity;
	}
}
