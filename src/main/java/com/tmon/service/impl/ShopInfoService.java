package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopInfoBiz;
import com.tmon.biz.check.KeyParamCheckBiz;
import com.tmon.biz.impl.ShopInfoBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.service.IShopInfoService;

public class ShopInfoService implements IShopInfoService {

	private String savePath;
	private String key;
	
	public ShopInfoService(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		this.key = request.getParameter("key");
	}
	
	@Override
	public ShopInfoDto getShopInfo()
	{
		ShopInfoDto result = null;
		
		ICheckParameterBiz check = new KeyParamCheckBiz(this.key);
		
		if(check.checkParam())
		{
			IShopInfoBiz biz = new ShopInfoBiz(this.savePath, this.key);
			result = biz.getShopInfo();
		}
		
		return result;
	}
}
