package com.tmon.biz.check;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.common.UtilBiz;

public class ListParamCheckBiz implements ICheckParameterBiz{
	
	private HttpServletRequest request = null;
	
	public ListParamCheckBiz(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public boolean checkParam()
	{
		String sortASC = request.getParameter("sortASC").toLowerCase();
		String sortKind = request.getParameter("sortKind").toLowerCase();
		String pageSize = request.getParameter("pageSize");
		String currentPage = request.getParameter("currentPage");
		
		if(UtilBiz.isNumber(pageSize) 
				&& UtilBiz.isNumber(currentPage) 
				&& !(sortASC == null || sortASC.equals("") || sortASC.equals("null"))
				&& !(sortKind == null || sortKind.equals("") || sortKind.equals("null")))
		{
			return true;
		}
		
		return false;
	}
	
	
}
