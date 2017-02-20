package com.tmon.dto;

//상점 이미지 속성
public class ShopImgInfoDto {
	
	//상점 PK 인덱스 정보
	private int n4ShopKey;
	//상점 이미지 url
	private String strShopImgUrl;
	//상점 이미지 출처
	private String strShopImgOrigin;
	
	public ShopImgInfoDto()
	{
		this.n4ShopKey = 0;
		this.strShopImgUrl = "";
		this.strShopImgOrigin = "";
	}
	
	public String getStrShopImgUrl() {
		return strShopImgUrl;
	}
	public void setStrShopImgUrl(String strShopImgUrl) {
		this.strShopImgUrl = strShopImgUrl;
	}
	public String getStrShopImgOrigin() {
		return strShopImgOrigin;
	}
	public void setStrShopImgOrigin(String strShopImgOrigin) {
		this.strShopImgOrigin = strShopImgOrigin;
	}
	public int getN4ShopKey() {
		return n4ShopKey;
	}
	public void setN4ShopKey(int n4ShopKey) {
		this.n4ShopKey = n4ShopKey;
	}
}
