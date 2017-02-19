package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopImgInfoBiz;
import com.tmon.biz.check.KeyParamCheckBiz;
import com.tmon.biz.impl.ShopImgInfoBiz;
import com.tmon.dto.ShopImgInfoDto;
import com.tmon.service.IShopImgInfoService;

public class ShopImgInfoService implements IShopImgInfoService{

	private String savePath;
	private String key;
	
	public ShopImgInfoService(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		this.key = request.getParameter("key");
	}
	
	@Override
	public ShopImgInfoDto getShopInfo()
	{
		ShopImgInfoDto entity = null;
		ICheckParameterBiz check = new KeyParamCheckBiz(this.key);
		
		if(check.checkParam())
		{
			IShopImgInfoBiz biz = new ShopImgInfoBiz(this.savePath, this.key);
			entity = biz.getShopImgInfo();
		}
		
		return entity;
	}
}
