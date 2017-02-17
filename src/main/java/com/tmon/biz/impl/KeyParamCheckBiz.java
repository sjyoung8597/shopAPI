package com.tmon.biz.impl;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;

public class KeyParamCheckBiz implements ICheckParameterBiz{
	
	private HttpServletRequest request = null;
	
	public KeyParamCheckBiz(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public boolean checkParam()
	{
		String Key = request.getParameter("key");
		
		if(UtilBiz.isNumber(Key))
		{
			return true;
		}
		
		return false;
	}
}
