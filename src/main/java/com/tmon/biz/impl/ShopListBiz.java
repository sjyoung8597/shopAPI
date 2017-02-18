package com.tmon.biz.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tmon.biz.IShopListBiz;
import com.tmon.biz.common.UtilBiz;
import com.tmon.biz.sort.SortFactoryBiz;
import com.tmon.dao.IShopDao;
import com.tmon.dao.impl.ShopDao;
import com.tmon.dto.ShopInfoDto;
import com.tmon.dto.ShopListDto;

public class ShopListBiz implements IShopListBiz{
	
	private String savePath = "";
	
	private String sortASC = "";
	private String sortKind = "";
	private int pageSize = 10;
	private int currentPage = 1;
	
	public ShopListBiz(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		this.sortASC = request.getParameter("sortASC").toLowerCase();
		this.sortKind = request.getParameter("sortKind").toLowerCase();
		this.pageSize = Integer.parseInt(request.getParameter("pageSize"));
		this.currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	public ShopListDto getShopList()
	{
		List<ShopInfoDto> list = new ArrayList<ShopInfoDto>();
		List<ShopInfoDto> sortList = new ArrayList<ShopInfoDto>();
		ShopListDto result = new ShopListDto();
		
		ShopInfoDto entity = null;
		
		IShopDao dao = new ShopDao(this.savePath);
		JSONObject jsonObject = dao.getShopList();
		
		if(jsonObject != null)
		{
			JSONArray shopList = (JSONArray) jsonObject.get("shop");
			
			for(int i = 0; i < shopList.size(); i++)
			{
				JSONObject shopObject = (JSONObject)shopList.get(i);
				
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
				
				list.add(entity);
			}
			
			//SortFactoryBiz factory = null;
			
			Collections.sort(list, new SortFactoryBiz(this.sortKind, this.sortASC).sortingProcess());
			
			for(ShopInfoDto sortEntity : list)
			{
				sortList.add(sortEntity);
			}

			result.setShopList(sortList.subList(this.pageSize*(this.currentPage-1), this.pageSize*this.currentPage));
			result.setTotalCount(list.size());
		}

		return result;
	}
	
}
