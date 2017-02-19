package com.tmon.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tmon.biz.ISortBiz;
import com.tmon.biz.common.UtilBiz;
import com.tmon.biz.sort.SortFactoryBiz;
import com.tmon.dto.ShopInfoDto;
import com.tmon.dto.ShopListDto;

public class SortBiz implements ISortBiz{
	
	private List<ShopInfoDto> list;
	
	private String sortASC = "";
	private String sortKind = "";
	private int pageSize = 10;
	private int currentPage = 1;
	
	public SortBiz(HttpServletRequest request, List<ShopInfoDto> list)
	{
		this.list = list;
		this.sortASC = request.getParameter("sortASC").toLowerCase();
		this.sortKind = request.getParameter("sortKind").toLowerCase();
		this.pageSize = Integer.parseInt(request.getParameter("pageSize"));
		this.currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	@Override
	public ShopListDto sorting()
	{
		List<ShopInfoDto> sortList = new ArrayList<ShopInfoDto>();
		ShopListDto result = new ShopListDto();
		
		//SortFactoryBiz factory = null;
		int totalCount = this.list.size();
		
		Collections.sort(this.list, new SortFactoryBiz(this.sortKind, this.sortASC).sortingProcess());
		
		for(ShopInfoDto sortEntity : list)
		{
			sortList.add(sortEntity);
		}
		
		result.setShopList(UtilBiz.PagingShopList(this.pageSize, this.currentPage, totalCount, sortList));
		result.setTotalCount(totalCount);
		
		return result;
	}
}
