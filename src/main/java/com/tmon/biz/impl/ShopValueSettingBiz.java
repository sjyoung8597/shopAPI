package com.tmon.biz.impl;

import java.util.List;

import com.tmon.biz.ISettingBiz;
import com.tmon.dao.ISetJsonDao;
import com.tmon.dao.impl.ShopValueSettingDao;
import com.tmon.dto.ShopInfoDto;

public class ShopValueSettingBiz implements ISettingBiz{
	private List<ShopInfoDto> list = null;
	private String savePath;
	
	public ShopValueSettingBiz(List<ShopInfoDto> list, String savePath)
	{
		this.list = list;
		this.savePath = savePath;
	}
	
	@Override
	public boolean setting()
	{
		//가치 산정 update
		ISetJsonDao shopValueSettingDao = new ShopValueSettingDao(this.list, this.savePath);
		boolean result = shopValueSettingDao.setJson();
		
		return result;
	}
}
