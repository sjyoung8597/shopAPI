package com.tmon.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public SortBiz(String sortASC, String sortKind, int pageSize, int currentPage, List<ShopInfoDto> list)
	{
		this.list = list;
		this.sortASC = sortASC;
		this.sortKind = sortKind;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	
	@Override
	public ShopListDto sorting()
	{
		List<ShopInfoDto> sortList = new ArrayList<ShopInfoDto>();
		ShopListDto result = new ShopListDto();
		int totalCount = this.list.size();
		
		//sort logic
		Collections.sort(this.list, new SortFactoryBiz(this.sortKind, this.sortASC).sortingProcess());
		
		//sort된 리스트 재 배열
		for(ShopInfoDto sortEntity : list)
		{
			sortList.add(sortEntity);
		}
		
		//paging 처리
		result.setShopList(UtilBiz.PagingShopList(this.pageSize, this.currentPage, totalCount, sortList));
		result.setTotalCount(totalCount);
		
		return result;
	}
}
