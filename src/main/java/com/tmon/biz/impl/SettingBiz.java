package com.tmon.biz.impl;

import com.tmon.biz.ISettingBiz;
import com.tmon.dao.IRuleSettingDao;
import com.tmon.dao.impl.RuleSettingDao;
import com.tmon.dto.RuleInfoDto;

public class SettingBiz implements ISettingBiz {
	
	private RuleInfoDto entity = null;
	
	public SettingBiz(RuleInfoDto entity)
	{
		this.entity = entity;
	}
	
	@Override
	public boolean setting()
	{
		IRuleSettingDao ruleSettingDao = new RuleSettingDao();
		boolean result = ruleSettingDao.settingRules(this.entity, "settingDB_table.json");
		
		return result;
	}
}
