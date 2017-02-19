package com.tmon.dto;

//규칙 정보 모델
public class RuleInfoDto {
	
	//고객가치 퍼센트
	private int n4CustomerValuePersent;
	//상점가치 퍼센트
	private int n4ShopValuePersent;
	 
	//조회수 퍼센트
	private int n4LookupPersent; 
	//좋아요 퍼센트
	private int n4LikePersent;
	//사용자평균점수 퍼센트
	private int n4UserAverageScorePersent;
	 
	//최신 정보 업데이트 날짜 퍼센트
	private int n4NewShopInfoPersent;
	//할인 여부 퍼센트
	private int n4PromotionYNPersent;
	
	//나중에 추가 한 경로 정보
	private String strRootPath;
	
	public RuleInfoDto()
	{
		
	}
	
	public RuleInfoDto(int n4CustomerValuePersent
			, int n4ShopValuePersent
			, int n4LookupPersent
			, int n4LikePersent
			, int n4UserAverageScorePersent
			, int n4NewShopInfoPersent
			, int n4PromotionYNPersent
			, String strRootPath)
	{
		this.n4CustomerValuePersent = n4CustomerValuePersent;
		this.n4ShopValuePersent = n4ShopValuePersent;
		this.n4LookupPersent = n4LookupPersent;
		this.n4LikePersent = n4LikePersent;
		this.n4UserAverageScorePersent = n4UserAverageScorePersent;
		this.n4NewShopInfoPersent = n4NewShopInfoPersent;
		this.n4PromotionYNPersent = n4PromotionYNPersent;
		this.strRootPath = strRootPath;
	}
	
	public String getStrRootPath() {
		return strRootPath;
	}
	public void setStrRootPath(String strRootPath) {
		this.strRootPath = strRootPath;
	}
	public int getN4CustomerValuePersent() {
		return n4CustomerValuePersent;
	}
	public void setN4CustomerValuePersent(int n4CustomerValuePersent) {
		this.n4CustomerValuePersent = n4CustomerValuePersent;
	}
	public int getN4ShopValuePersent() {
		return n4ShopValuePersent;
	}
	public void setN4ShopValuePersent(int n4ShopValuePersent) {
		this.n4ShopValuePersent = n4ShopValuePersent;
	}
	public int getN4LookupPersent() {
		return n4LookupPersent;
	}
	public void setN4LookupPersent(int n4LookupPersent) {
		this.n4LookupPersent = n4LookupPersent;
	}
	public int getN4LikePersent() {
		return n4LikePersent;
	}
	public void setN4LikePersent(int n4LikePersent) {
		this.n4LikePersent = n4LikePersent;
	}
	public int getN4UserAverageScorePersent() {
		return n4UserAverageScorePersent;
	}
	public void setN4UserAverageScorePersent(int n4UserAverageScorePersent) {
		this.n4UserAverageScorePersent = n4UserAverageScorePersent;
	}
	public int getN4NewShopInfoPersent() {
		return n4NewShopInfoPersent;
	}
	public void setN4NewShopInfoPersent(int n4NewShopInfoPersent) {
		this.n4NewShopInfoPersent = n4NewShopInfoPersent;
	}
	public int getN4PromotionYNPersent() {
		return n4PromotionYNPersent;
	}
	public void setN4PromotionYNPersent(int n4PromotionYNPersent) {
		this.n4PromotionYNPersent = n4PromotionYNPersent;
	}
}
