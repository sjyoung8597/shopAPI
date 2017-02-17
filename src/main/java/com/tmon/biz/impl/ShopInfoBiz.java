package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.dao.IShopDao;
import com.tmon.dao.impl.ShopDao;
import com.tmon.dto.ShopInfoDto;

public class ShopInfoBiz {
	
	private String savePath = "";
	private String key = "";
	
	public ShopInfoBiz(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		this.key = request.getParameter("key");
	}
	
	public ShopInfoDto getShopInfo() 
	{
		ShopInfoDto entity = null;
		
		IShopDao dao = new ShopDao(this.savePath);
		JSONObject jsonObject = dao.getShopList();
		
		if(jsonObject != null)
		{
			JSONArray shopList = (JSONArray) jsonObject.get("shop");
			
			for(int i = 0; i < shopList.size(); i++)
			{
				JSONObject shopObject = (JSONObject)shopList.get(i);
				
				if(shopObject.get("n4ShopKey").toString() == this.key)
				{
					entity = new ShopInfoDto();
					
					entity.setN4ShopKey((int)shopObject.get("n4ShopKey"));
					entity.setStrShopName(shopObject.get("strShopName").toString());
					entity.setStrShopDescription(shopObject.get("strShopDescription").toString());
					entity.setStrPhoneNum(shopObject.get("strPhoneNum").toString());
					entity.setN4Lookup((int)shopObject.get("n4Lookup"));
					entity.setN4Like((int)shopObject.get("n4Like"));
					entity.setN4UserAverageScore((int)shopObject.get("n4UserAverageScore"));
					entity.setStrShopImg(shopObject.get("strShopImg").toString());
					entity.setStrShopKind((char)shopObject.get("strShopKind"));
					entity.setIsShopPromotionYN((boolean)shopObject.get("isShopPromotionYN"));
					entity.setN4ShopValueScore((int)shopObject.get("n4ShopValueScore"));
					entity.setDtModifyDate(UtilBiz.StringToDate(shopObject.get("dtModifyDate").toString()));
				}
			}
		}
		
		return entity;
	}
}
