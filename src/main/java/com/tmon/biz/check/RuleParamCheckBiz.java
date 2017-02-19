package com.tmon.biz.check;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.common.UtilBiz;

public class RuleParamCheckBiz implements ICheckParameterBiz{

	private String CustomerValuePersent;
	private String ShopValuePersent;
	private String LookupPersent;
	private String LikePersent;
	private String UserAverageScorePersent;
	private String NewShopInfoPersent;
	private String PromotionYNPersent;

	public RuleParamCheckBiz(String CustomerValuePersent, String ShopValuePersent
			, String LookupPersent, String LikePersent
			, String UserAverageScorePersent, String NewShopInfoPersent
			, String PromotionYNPersent)
	{
		this.CustomerValuePersent = CustomerValuePersent;
		this.ShopValuePersent = ShopValuePersent;
		this.LookupPersent = LookupPersent;
		this.LikePersent = LikePersent;
		this.UserAverageScorePersent = UserAverageScorePersent;
		this.NewShopInfoPersent = NewShopInfoPersent;
		this.PromotionYNPersent = PromotionYNPersent;
	}
	
	public boolean checkParam()
	{
		if(UtilBiz.isNumber(this.CustomerValuePersent) 
				&& UtilBiz.isNumber(this.ShopValuePersent) 
				&& UtilBiz.isNumber(this.LookupPersent) 
				&& UtilBiz.isNumber(this.LikePersent)
				&& UtilBiz.isNumber(this.UserAverageScorePersent)
				&& UtilBiz.isNumber(this.NewShopInfoPersent)
				&& UtilBiz.isNumber(this.PromotionYNPersent))
		{
			return true;
		}
		
		return false;
	}
}
