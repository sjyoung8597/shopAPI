package com.tmon.biz.impl;

import java.util.List;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.common.ResultConstantsBiz;
import com.tmon.dao.ISetJsonDao;
import com.tmon.dao.impl.ShopValueSettingDao;
import com.tmon.dto.ResponseCodeDto;
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
	public ResponseCodeDto setting()
	{
		ResponseCodeDto result = null;
		
		//가치 산정 update
		ISetJsonDao shopValueSettingDao = new ShopValueSettingDao(this.list, this.savePath);
		boolean success = shopValueSettingDao.setJson();
		
		result = new ResponseCodeDto();
		result.setN4ResultCode(success == true ? 0 : 1);
		result.setStrResultMessage((String.valueOf(ResultConstantsBiz.ResultValue.get(Integer.toString(success == true ? 0 : 1)))));

		
		return result;
	}
}
