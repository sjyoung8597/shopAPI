package com.tmon.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.impl.ListParamCheckBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.service.IShopListService;

public class ShopListService implements IShopListService{

private HttpServletRequest request = null;
	
	public ShopListService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public List<ShopInfoDto> getShopList()
	{
		List<ShopInfoDto> entity = null;
		ICheckParameterBiz check = new ListParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			IShopListBiz biz = new ShopListBiz(this.request);
			entity = biz.getShopList();
		}
		
		return entity;
	}
}
