package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.biz.common.UtilBiz;
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
				
				if(shopObject.get("n4ShopKey").toString().equals(this.key))
				{
					entity = new ShopInfoDto();
					
					entity.setN4ShopKey(Integer.parseInt(shopObject.get("n4ShopKey").toString()));
					entity.setStrShopName(shopObject.get("strShopName").toString());
					entity.setStrShopDescription(shopObject.get("strShopDescription").toString());
					entity.setStrPhoneNum(shopObject.get("strPhoneNum").toString());
					entity.setN4Lookup(Integer.parseInt(shopObject.get("n4Lookup").toString()));
					entity.setN4Like(Integer.parseInt(shopObject.get("n4Like").toString()));
					entity.setN4UserAverageScore(Integer.parseInt(shopObject.get("n4UserAverageScore").toString()));
					entity.setStrShopImg(shopObject.get("strShopImg").toString());
					entity.setStrShopKind(shopObject.get("strShopKind").toString());
					entity.setIsShopPromotionYN(new Boolean(shopObject.get("isShopPromotionYN").toString()).booleanValue());
					entity.setN4ShopValueScore(Integer.parseInt(shopObject.get("n4ShopValueScore").toString()));
					entity.setDtModifyDate(UtilBiz.StringToDate(shopObject.get("dtModifyDate").toString()));
					
					break;
				}
			}
		}
		
		return entity;
	}
}
