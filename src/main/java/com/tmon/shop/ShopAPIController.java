package com.tmon.shop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmon.dto.*;
import com.tmon.service.*;
import com.tmon.service.impl.*;

@RestController
public class ShopAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ShopAPIController.class);
	
	
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
	
	
	
	
	@RequestMapping(value="/useApi", method=RequestMethod.GET)
	public @ResponseBody String couponUseApi(HttpServletRequest request) throws IOException {
		
		JSONObject obj = new JSONObject();
		//RuleInfoDto ruleEntity = new RuleInfoDto();
		String path = new File("./").toPath() + "/settingJSON.json";
		String testPath = this.getClass().getResource("").getPath();
		String url = this.getClass().getResource("").getPath(); 
		
		String classPath = new ShopAPIController().getClass().getResource("").getPath();
		 String request1 = request.getSession().getServletContext().getRealPath("\\");
		obj.put("path", path);
		obj.put("testPath", testPath);
		obj.put("url", url);
		obj.put("classPath", classPath);
		obj.put("request1", request1); 
		obj.put("request1", request1); 
		//obj.put("ioApache", ioApache);
	   
		
		try {
			 
			FileWriter files = new FileWriter(new File(request1+"settingJSON8597.json"));
			files.write(obj.toJSONString());
			files.flush();
			
			files.close();
			
			File f = new File("settingJSON3.json");
			if(f.isFile())
			{

			}
			else
			{

			}
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		return request1;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home222";
	}
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)//, produces = "application/json"
	public @ResponseBody List<ShopInfoDto> OneVerification(HttpServletRequest request){

		List<ShopInfoDto> resultData = new ArrayList<ShopInfoDto>();
	    ShopInfoDto entity = new ShopInfoDto();
	    
	    resultData.add(entity);
	    resultData.add(entity);
	    resultData.add(entity);
	    resultData.add(entity);

	    logger.info("Welcome home! The client locale is {}.", entity);
	    
	    return resultData;
	}
	
}
