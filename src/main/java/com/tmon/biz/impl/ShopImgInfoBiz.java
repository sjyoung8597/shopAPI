package com.tmon.biz.impl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.biz.IShopImgInfoBiz;
import com.tmon.dao.IGetJsonDao;
import com.tmon.dao.impl.ShopImgDao;
import com.tmon.dto.ShopImgInfoDto;

public class ShopImgInfoBiz implements IShopImgInfoBiz{

	private String savePath = "";
	private String key = "";
	
	public ShopImgInfoBiz(String savePath, String key)
	{
		this.savePath = savePath;
		this.key = key;
	}
	
	@Override
	public ShopImgInfoDto getShopImgInfo() 
	{
		ShopImgInfoDto entity = null;
		
		IGetJsonDao dao = new ShopImgDao(this.savePath);
		JSONObject jsonObject = dao.getJson();
		
		if(jsonObject != null)
		{
			JSONArray imgList = (JSONArray) jsonObject.get("shopImgInfo");
			
			for(int i = 0; i < imgList.size(); i++)
			{
				JSONObject shopObject = (JSONObject)imgList.get(i);
				
				if(shopObject.get("n4ShopKey").toString().equals(this.key))
				{
					entity = new ShopImgInfoDto();
					
					entity.setN4ShopKey(Integer.parseInt(shopObject.get("n4ShopKey").toString()));
					entity.setStrShopImgUrl(shopObject.get("strShopImgUrl").toString());
					entity.setStrShopImgOrigin(shopObject.get("strShopImgOrigin").toString());
					
					break;
				}
			}
		}
		
		return entity;
	}
}
