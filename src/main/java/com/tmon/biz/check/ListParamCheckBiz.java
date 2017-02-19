package com.tmon.biz.check;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.common.UtilBiz;

public class ListParamCheckBiz implements ICheckParameterBiz{
	
	private String sortASC;
	private String sortKind;
	private String pageSize;
	private String currentPage;
	
	public ListParamCheckBiz(String sortASC, String sortKind, String pageSize, String currentPage)
	{
		this.sortASC = sortASC;
		this.sortKind = sortKind;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	
	public boolean checkParam()
	{
		if(UtilBiz.isNumber(this.pageSize) 
				&& UtilBiz.isNumber(this.currentPage) 
				&& !(this.sortASC == null || this.sortASC.equals("") || this.sortASC.equals("null"))
				&& !(this.sortKind == null || this.sortKind.equals("") || this.sortKind.equals("null")))
		{
			return true;
		}
		
		return false;
	}
	
	
}
