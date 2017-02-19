package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.tmon.biz.IRuleInfoBiz;
import com.tmon.dao.IGetJsonDao;
import com.tmon.dao.impl.RuleDao;
import com.tmon.dto.RuleInfoDto;

public class RuleInfoBiz implements IRuleInfoBiz{
	private String savePath = "";
	
	public RuleInfoBiz(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
	}
	
	@Override
	public RuleInfoDto getRuleInfo() 
	{
		RuleInfoDto entity = null;
		
		IGetJsonDao dao = new RuleDao(this.savePath);
		JSONObject jsonObject = dao.getJson();
		
		if(jsonObject != null)
		{
			entity = new RuleInfoDto();
			
			entity.setN4CustomerValuePersent(Integer.parseInt(jsonObject.get("n4CustomerValuePersent").toString()));
			entity.setN4ShopValuePersent(Integer.parseInt(jsonObject.get("n4ShopValuePersent").toString()));
			entity.setN4LookupPersent(Integer.parseInt(jsonObject.get("n4LookupPersent").toString()));
			entity.setN4LikePersent(Integer.parseInt(jsonObject.get("n4LikePersent").toString()));
			entity.setN4UserAverageScorePersent(Integer.parseInt(jsonObject.get("n4UserAverageScorePersent").toString()));
			entity.setN4NewShopInfoPersent(Integer.parseInt(jsonObject.get("n4NewShopInfoPersent").toString()));
			entity.setN4PromotionYNPersent(Integer.parseInt(jsonObject.get("n4PromotionYNPersent").toString()));
		}
		
		return entity;
	}
}
