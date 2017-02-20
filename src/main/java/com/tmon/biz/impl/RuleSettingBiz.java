package com.tmon.biz.impl;

import com.tmon.biz.ISettingBiz;
import com.tmon.biz.common.ResultConstantsBiz;
import com.tmon.dao.ISetJsonDao;
import com.tmon.dao.impl.RuleSettingDao;
import com.tmon.dto.ResponseCodeDto;
import com.tmon.dto.RuleInfoDto;

public class RuleSettingBiz implements ISettingBiz {
	
	private RuleInfoDto entity = null;
	private String savePath = "";
	
	public RuleSettingBiz(RuleInfoDto entity, String savePath)
	{
		this.entity = entity;
		this.savePath = savePath;
	}
	
	@Override
	public ResponseCodeDto setting()
	{
		ResponseCodeDto result = null;
		
		ISetJsonDao ruleSettingDao = new RuleSettingDao(this.entity, this.savePath);
		boolean success = ruleSettingDao.setJson();

		result = new ResponseCodeDto();
		result.setN4ResultCode(success == true ? 0 : 1);
		result.setStrResultMessage((String.valueOf(ResultConstantsBiz.ResultValue.get(Integer.toString(success == true ? 0 : 1)))));

		return result;
	}
}
