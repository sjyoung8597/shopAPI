package com.tmon.dto.response;

import com.tmon.dto.ResponseCodeDto;
import com.tmon.dto.ShopImgInfoDto;

public class ShopImgResponseDto {

	private ShopImgInfoDto shopImgInfo;
	
	private ResponseCodeDto responseCode;
	
	public ResponseCodeDto getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCodeDto responseCode) {
		this.responseCode = responseCode;
	}

	public ShopImgInfoDto getShopImgInfo() {
		return shopImgInfo;
	}

	public void setShopImgInfo(ShopImgInfoDto shopImgInfo) {
		this.shopImgInfo = shopImgInfo;
	}
}
