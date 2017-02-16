package com.tmon.dao;

import com.tmon.dto.RuleInfoDto;

public interface IRuleSettingDao {
	
	public boolean settingRules(RuleInfoDto requestRule, String fileName);
}