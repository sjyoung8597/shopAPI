package com.tmon.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.dao.ISetJsonDao;
import com.tmon.dto.ShopInfoDto;

public class ShopValueSettingDao implements ISetJsonDao{
	private List<ShopInfoDto> list;
	private String savePath;
	
	public ShopValueSettingDao(List<ShopInfoDto> list, String savePath)
	{
		this.list = list;
		this.savePath = savePath;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean setJson()
	{
		boolean success = false;
		JSONArray jsonResult = new JSONArray();
		JSONObject jsonObj;
		String fileName = "shopInfoDB_table.json";
		
		for(int i = 0; i < this.list.size(); i++)
		{
			jsonObj = new JSONObject();
			
			jsonObj.put("n4ShopKey", this.list.get(i).getN4ShopKey());
			jsonObj.put("strShopName", this.list.get(i).getStrShopName());
			jsonObj.put("strShopDescription", this.list.get(i).getStrShopDescription());
			jsonObj.put("strPhoneNum", this.list.get(i).getStrPhoneNum());
			jsonObj.put("n4Lookup", this.list.get(i).getN4Lookup());
			jsonObj.put("n4Like", this.list.get(i).getN4Like());
			jsonObj.put("n4UserAverageScore", this.list.get(i).getN4UserAverageScore());
			jsonObj.put("strShopImg", this.list.get(i).getStrShopImg());
			jsonObj.put("strShopKind", this.list.get(i).getStrShopKind());
			jsonObj.put("isShopPromotionYN", this.list.get(i).getIsShopPromotionYN());
			jsonObj.put("n4ShopValueScore", this.list.get(i).getN4ShopValueScore());
			jsonObj.put("dtModifyDate", this.list.get(i).getN4ModifyDate());
			
			jsonResult.add(i, jsonObj);
		}
		JSONObject obj = new JSONObject();
		obj.put("shopList", jsonResult);
		
		try {
			
			FileWriter file = new FileWriter(new File(this.savePath + fileName));
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
