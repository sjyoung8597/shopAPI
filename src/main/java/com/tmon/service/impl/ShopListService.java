package com.tmon.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ICheckParameterBiz;
import com.tmon.biz.IShopListBiz;
import com.tmon.biz.ISortBiz;
import com.tmon.biz.check.ListParamCheckBiz;
import com.tmon.biz.impl.ShopListBiz;
import com.tmon.biz.impl.SortBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.dto.response.ShopListResponseDto;
import com.tmon.service.IShopListService;

public class ShopListService implements IShopListService{

	private String savePath;
	private String sortASC;
	private String sortKind;
	private String pageSize;
	private String currentPage;
	
	public ShopListService(HttpServletRequest request)
	{
		this.savePath = request.getSession().getServletContext().getRealPath("\\");
		
		this.sortASC = request.getParameter("sortASC").toLowerCase();
		this.sortKind = request.getParameter("sortKind").toLowerCase();
		this.pageSize = request.getParameter("pageSize");
		this.currentPage = request.getParameter("currentPage");
	}
	
	@Override
	public ShopListResponseDto getShopList()
	{
		ShopListResponseDto result = null;
		List<ShopInfoDto> list = null;
		
		ICheckParameterBiz check = new ListParamCheckBiz(this.sortASC, this.sortKind, this.pageSize, this.currentPage);
		
		if(check.checkParam())
		{
			IShopListBiz listBiz = new ShopListBiz(this.savePath);
			list = listBiz.getShopList();
			
			ISortBiz biz = new SortBiz(this.sortASC, this.sortKind, Integer.parseInt(this.pageSize), Integer.parseInt(this.currentPage), list);
			result = biz.sorting();
		}
		
		return result;
	}
}
