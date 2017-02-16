package com.tmon.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.service.IShopAPIService;

public class ShopAPIService implements IShopAPIService {
	
	@Override
	public boolean settingService(HttpServletRequest request)
	{
		return true;
	}
}
