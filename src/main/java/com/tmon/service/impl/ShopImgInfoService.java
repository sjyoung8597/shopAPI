package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopImgInfoBiz;
import com.tmon.biz.check.KeyParamCheckBiz;
import com.tmon.biz.impl.ShopImgInfoBiz;
import com.tmon.dto.ShopImgInfoDto;
import com.tmon.service.IShopImgInfoService;

public class ShopImgInfoService implements IShopImgInfoService{

private HttpServletRequest request = null;
	
	public ShopImgInfoService(HttpServletRequest request)
	{
		this.request = request;
	}
	
	@Override
	public ShopImgInfoDto getShopInfo()
	{
		ShopImgInfoDto entity = null;
		ICheckParameterBiz check = new KeyParamCheckBiz(this.request);
		
		if(check.checkParam())
		{
			IShopImgInfoBiz biz = new ShopImgInfoBiz(this.request);
			entity = biz.getShopImgInfo();
		}
		
		return entity;
	}
}
