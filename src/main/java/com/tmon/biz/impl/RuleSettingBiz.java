package com.tmon.biz.impl;

import com.tmon.biz.ISettingBiz;
import com.tmon.dao.ISetJsonDao;
import com.tmon.dao.impl.RuleSettingDao;
import com.tmon.dto.RuleInfoDto;

public class RuleSettingBiz implements ISettingBiz {
	
	private RuleInfoDto entity = null;
	
	public RuleSettingBiz(RuleInfoDto entity)
	{
		this.entity = entity;
	}
	
	@Override
	public boolean setting()
	{
		ISetJsonDao ruleSettingDao = new RuleSettingDao(this.entity);
		boolean result = ruleSettingDao.setJson();
		
		return result;
	}
}
