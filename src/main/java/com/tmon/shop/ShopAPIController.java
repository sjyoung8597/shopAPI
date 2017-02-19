package com.tmon.shop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmon.dto.*;
import com.tmon.service.*;
import com.tmon.service.impl.*;

@RestController
public class ShopAPIController {
	
	@RequestMapping(value="/firstSetting", method=RequestMethod.GET)
	public @ResponseBody boolean firstRuleSetting(HttpServletRequest request) {
		
		ISettingService ruleSettingService = new FirstSettingService(70,30,30,40,30,55,45, request);
		boolean result = ruleSettingService.settingService();

		return result;
	}
	
	@RequestMapping(value="/ruleSetting", method=RequestMethod.GET)
	public @ResponseBody boolean ruleSetting(HttpServletRequest request) {
		
		ISettingService ruleSettingService = new RuleSettingService(request);
		boolean result = ruleSettingService.settingService();

		return result;
	}
	
	@RequestMapping(value="/shopInfo", method=RequestMethod.GET)
	public @ResponseBody ShopInfoDto shopDetail(HttpServletRequest request) {
		
		IShopInfoService shopInfoService = new ShopInfoService(request);
		ShopInfoDto result = shopInfoService.getShopInfo();

		return result;
	}
	
	@RequestMapping(value="/shopList", method=RequestMethod.GET)
	public @ResponseBody ShopListDto shopList(HttpServletRequest request) {
		
		IShopListService shopListService = new ShopListService(request);
		ShopListDto result = shopListService.getShopList();

		return result;
	}
	
	@RequestMapping(value="/shopImgInfo", method=RequestMethod.GET)
	public @ResponseBody ShopImgInfoDto shopImgInfo(HttpServletRequest request) {
		
		IShopImgInfoService shopImgInfoService = new ShopImgInfoService(request);
		ShopImgInfoDto result = shopImgInfoService.getShopInfo();

		return result;
	}
	
	@RequestMapping(value="/valueScoreSetting", method=RequestMethod.GET)
	public @ResponseBody boolean shopScoreSetting(HttpServletRequest request) {
		
		ISettingService settingService = new ValueScoreSettingService(request);
		boolean result = settingService.settingService();

		return result;
	}
}
