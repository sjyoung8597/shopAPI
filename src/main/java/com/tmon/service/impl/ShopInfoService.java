package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopInfoBiz;
import com.tmon.biz.check.KeyParamCheckBiz;
import com.tmon.biz.impl.ShopInfoBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.service.IShopInfoService;

public class ShopInfoService implements IShopInfoService {

	private HttpServletRequest request = null;
	
	public ShopInfoService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public ShopInfoDto getShopInfo()
	{
		ShopInfoDto entity = null;
		ICheckParameterBiz check = new KeyParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			IShopInfoBiz biz = new ShopInfoBiz(this.request);
			entity = biz.getShopInfo();
		}
		
		return entity;
	}
}
