package com.tmon.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.ISortBiz;
import com.tmon.biz.check.ListParamCheckBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.biz.impl.SortBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.dto.ShopListDto;
import com.tmon.service.IShopListService;

public class ShopListService implements IShopListService{

	private HttpServletRequest request = null;
	
	public ShopListService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	@Override
	public ShopListDto getShopList()
	{
		ShopListDto entity = null;
		List<ShopInfoDto> list = null;
		
		ICheckParameterBiz check = new ListParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			IShopListBiz listBiz = new ShopListBiz(this.request);
			list = listBiz.getShopList();
			
			ISortBiz biz = new SortBiz(this.request, list);
			entity = biz.sorting();
		}
		
		return entity;
	}
}
