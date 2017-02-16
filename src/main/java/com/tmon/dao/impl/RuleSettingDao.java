package com.tmon.dao.impl;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.tmon.dao.IRuleSettingDao;
import com.tmon.dto.RuleInfoDto;

public class RuleSettingDao implements IRuleSettingDao{
	
	@Override
	public boolean settingRules(RuleInfoDto entity, String fileName)
	{
		boolean success = false;
		JSONObject obj = new JSONObject();
		
		obj.put("N4CustomerValuePersent", entity.getN4CustomerValuePersent());
		obj.put("N4ShopValuePersent", entity.getN4ShopValuePersent());
		obj.put("N4LookupPersent", entity.getN4LookupPersent());
		obj.put("N4LikePersent", entity.getN4LikePersent());
		obj.put("N4UserAverageScorePersent", entity.getN4UserAverageScorePersent());
		obj.put("N4NewShopInfoPersent", entity.getN4NewShopInfoPersent());
		obj.put("N4PromotionYNPersent", entity.getN4PromotionYNPersent());
		
		try {
			 
			FileWriter file = new FileWriter(fileName);
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			success = true;
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
}
