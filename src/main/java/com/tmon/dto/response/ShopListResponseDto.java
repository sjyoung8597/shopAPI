package com.tmon.dto.response;

import java.util.List;

import com.tmon.dto.ShopInfoDto;

public class ShopListResponseDto {
	
	//해당 상점 PK 인덱스
	private int totalCount;

	private List<ShopInfoDto> shopList;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<ShopInfoDto> getShopList() {
		return shopList;
	}

	public void setShopList(List<ShopInfoDto> shopList) {
		this.shopList = shopList;
	}
		
		
}
