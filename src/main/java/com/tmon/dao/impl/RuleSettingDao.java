package com.tmon.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.tmon.dao.ISetJsonDao;
import com.tmon.dto.RuleInfoDto;

public class RuleSettingDao implements ISetJsonDao{
	
	private RuleInfoDto entity;
	
	public RuleSettingDao(RuleInfoDto entity)
	{
		this.entity = entity;
	}
	
	@Override
	public boolean setJson()
	{
		boolean success = false;
		JSONObject obj = new JSONObject();
		String fileName = "settingDB_table.json";
		
		obj.put("n4CustomerValuePersent", this.entity.getN4CustomerValuePersent());
		obj.put("n4ShopValuePersent", this.entity.getN4ShopValuePersent());
		obj.put("n4LookupPersent", this.entity.getN4LookupPersent());
		obj.put("n4LikePersent", this.entity.getN4LikePersent());
		obj.put("n4UserAverageScorePersent", this.entity.getN4UserAverageScorePersent());
		obj.put("n4NewShopInfoPersent", this.entity.getN4NewShopInfoPersent());
		obj.put("n4PromotionYNPersent", this.entity.getN4PromotionYNPersent());
		
		try {
			
			FileWriter file = new FileWriter(new File(this.entity.getStrRootPath() + fileName));
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
