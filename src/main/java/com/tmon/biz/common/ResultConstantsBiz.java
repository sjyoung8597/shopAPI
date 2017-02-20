package com.tmon.biz.common;

import java.util.HashMap;
import java.util.Map;

public class ResultConstantsBiz {
	public static final Map<String, Object> ResultValue = new HashMap<String, Object>();
	static {
		ResultValue.put("0", "처리완료"); 
		ResultValue.put("-1", "처리 에러"); 
		//기타 등등등
	}
}
