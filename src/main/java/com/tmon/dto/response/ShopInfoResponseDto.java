package com.tmon.dto.response;

import com.tmon.dto.ResponseCodeDto;
import com.tmon.dto.ShopInfoDto;

public class ShopInfoResponseDto {

	private ShopInfoDto shopInfo;
	
	private ResponseCodeDto responseCode;
	
	public ResponseCodeDto getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCodeDto responseCode) {
		this.responseCode = responseCode;
	}

	public ShopInfoDto getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(ShopInfoDto shopInfo) {
		this.shopInfo = shopInfo;
	}
		
		
}
