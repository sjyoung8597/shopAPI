package com.tmon.biz.check;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.common.UtilBiz;

public class KeyParamCheckBiz implements ICheckParameterBiz{
	
	private String key;
	
	public KeyParamCheckBiz(String key)
	{
		this.key = key;
	}
	
	public boolean checkParam()
	{
		if(UtilBiz.isNumber(this.key))
		{
			return true;
		}
		
		return false;
	}
}
