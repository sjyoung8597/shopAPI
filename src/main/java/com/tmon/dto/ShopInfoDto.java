package com.tmon.dto;

import java.util.Date;

//각각의 상점 정볼를 담는 모델(엔티티) class입니다.
public class ShopInfoDto {
	
	//해당 상점 PK 인덱스
	private int n4ShopKey;
	//상점명
	private String strShopName;
	//상점설명
	private String strShopDescription;
	//상점연락처
	private String strPhoneNum;
	//상점조회수 (20억명 이상 되지 않을것 같아 int로 함)
	private int n4Lookup;
	//좋아요 수
	private int n4Like;
	//상점 사용자 평점
	private int n4UserAverageScore;
	//상점 사진
	private String strShopImg;
	//상점 유형
	private String strShopKind;
	//할인 이벤트 여부
	private boolean isShopPromotionYN;
	//가치 점수
	private int n4ShopValueScore;
	//최종 수정일
	private int n4ModifyDate;
	
	public ShopInfoDto()
	{
		this.n4ShopKey = 0;
		this.strShopName = "";
		this.strShopDescription ="";
		this.strPhoneNum = "";
		this.n4Lookup = 0;
		this.n4Like = 0;
		this.n4UserAverageScore = 0;
		this.strShopImg ="";
		this.strShopKind = "";
		this.isShopPromotionYN = false;
		this.n4ShopValueScore = 0;
		this.n4ModifyDate = 0;
		
	}
	
	public String getStrShopName() {
		return strShopName;
	}
	public void setStrShopName(String strShopName) {
		this.strShopName = strShopName;
	}
	public String getStrShopDescription() {
		return strShopDescription;
	}
	public void setStrShopDescription(String strShopDescription) {
		this.strShopDescription = strShopDescription;
	}
	public String getStrPhoneNum() {
		return strPhoneNum;
	}
	public void setStrPhoneNum(String strPhoneNum) {
		this.strPhoneNum = strPhoneNum;
	}
	public int getN4Lookup() {
		return n4Lookup;
	}
	public void setN4Lookup(int n4Lookup) {
		this.n4Lookup = n4Lookup;
	}
	public int getN4Like() {
		return n4Like;
	}
	public void setN4Like(int n4Like) {
		this.n4Like = n4Like;
	}
	public String getStrShopImg() {
		return strShopImg;
	}
	public void setStrShopImg(String strShopImg) {
		this.strShopImg = strShopImg;
	}
	public String getStrShopKind() {
		return strShopKind;
	}
	public void setStrShopKind(String strShopKind) {
		this.strShopKind = strShopKind;
	}
	public boolean getIsShopPromotionYN() {
		return isShopPromotionYN;
	}
	public void setIsShopPromotionYN(boolean isShopPromotionYN) {
		this.isShopPromotionYN = isShopPromotionYN;
	}
	public int getN4ShopValueScore() {
		return n4ShopValueScore;
	}
	public void setN4ShopValueScore(int n4ShopValueScore) {
		this.n4ShopValueScore = n4ShopValueScore;
	}
	public int getN4ModifyDate() {
		return n4ModifyDate;
	}
	public void setN4ModifyDate(int n4ModifyDate) {
		this.n4ModifyDate = n4ModifyDate;
	}
	public int getN4ShopKey() {
		return n4ShopKey;
	}
	public void setN4ShopKey(int n4ShopKey) {
		this.n4ShopKey = n4ShopKey;
	}

	public int getN4UserAverageScore() {
		return n4UserAverageScore;
	}

	public void setN4UserAverageScore(int n4UserAverageScore) {
		this.n4UserAverageScore = n4UserAverageScore;
	}
	
}
