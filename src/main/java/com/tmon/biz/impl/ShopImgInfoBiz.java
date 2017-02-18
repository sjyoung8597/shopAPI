package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.biz.IShopImgInfoBiz;
import com.tmon.dao.IShopListDao;
import com.tmon.dao.impl.ShopImgDao;
import com.tmon.dto.ShopImgInfoDto;

public class ShopImgInfoBiz implements IShopImgInfoBiz{

	private String savePath = "";
	private String key = "";
	
	public ShopImgInfoBiz(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		this.key = request.getParameter("key");
	}
	
	public ShopImgInfoDto getShopImgInfo() 
	{
		ShopImgInfoDto entity = null;
		
		IShopListDao dao = new ShopImgDao(this.savePath);
		JSONObject jsonObject = dao.getShopList();
		
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
