package com.tmon.dto;

public class ResponseCodeDto {
	
	//결과 코드 정보
	private int n4ResultCode;
	//결과 메세지
	private String strResultMessage;
	
	public ResponseCodeDto()
	{
		this.n4ResultCode = -1;
		this.strResultMessage = "";
	}
	
	public int getN4ResultCode() {
		return n4ResultCode;
	}
	public void setN4ResultCode(int n4ResultCode) {
		this.n4ResultCode = n4ResultCode;
	}
	public String getStrResultMessage() {
		return strResultMessage;
	}
	public void setStrResultMessage(String string) {
		this.strResultMessage = string;
	}
	
}
