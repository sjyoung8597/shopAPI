package com.tmon.dto;

import java.util.List;

public class ShopListDto {
	
	//해당 상점 PK 인덱스
	private int totalCount;

	private List<ShopInfoDto> shop;
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<ShopInfoDto> getShopList() {
		return shop;
	}

	public void setShopList(List<ShopInfoDto> shop) {
		this.shop = shop;
	}
		
		
}
