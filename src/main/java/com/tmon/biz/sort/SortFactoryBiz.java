package com.tmon.biz.sort;

public class SortFactoryBiz {
	
	private String sortKind;
	private String sortASC;
	
	public SortFactoryBiz(String sortKind, String sortASC)
	{
		this.sortKind = sortKind;
		this.sortASC = sortASC;
	}
	
	public SortBiz sortingProcess()
	{
		SortBiz sort = null;
		
		if(this.sortKind.toLowerCase().equals("shopkey"))
		{
			sort = new SortShopKeyBiz(this.sortASC);
		}
		else if(this.sortKind.toLowerCase().equals("lookup"))
		{
			sort = new SortLookupBiz(this.sortASC);
		}
		else if(this.sortKind.toLowerCase().equals("like"))
		{
			sort = new SortLikeBiz(this.sortASC);
		}
		else if(this.sortKind.toLowerCase().equals("shopvaluescore")) //가치 정보 정렬 (중요)
		{
			
		}
		
		
		
		return sort;
	}
}
