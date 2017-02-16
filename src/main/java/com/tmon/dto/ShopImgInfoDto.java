package com.tmon.dto;

//상점 이미지 속성
public class ShopImgInfoDto {
	
	//상점 PK 인덱스 정보
	private int n4ShopKey;
	//상점 이미지 url
	private String strShopImgUrl;
	//상점 이미지 출처
	private char strShopImgSource;
	
	public String getStrShopImgUrl() {
		return strShopImgUrl;
	}
	public void setStrShopImgUrl(String strShopImgUrl) {
		this.strShopImgUrl = strShopImgUrl;
	}
	public char getStrShopImgSource() {
		return strShopImgSource;
	}
	public void setStrShopImgSource(char strShopImgSource) {
		this.strShopImgSource = strShopImgSource;
	}
	public int getN4ShopKey() {
		return n4ShopKey;
	}
	public void setN4ShopKey(int n4ShopKey) {
		this.n4ShopKey = n4ShopKey;
	}
}
