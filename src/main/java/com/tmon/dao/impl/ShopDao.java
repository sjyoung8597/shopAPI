package com.tmon.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tmon.dao.IShopDao;

public class ShopDao implements IShopDao{
	
	private String savePath;
	
	public ShopDao(String savePath)
	{
		this.savePath = savePath;
	}

	public JSONObject getShopList()
	{
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		String fileName = "shopInfoDB_table.json";
		
		try {
			Object obj = parser.parse(new FileReader(new File(this.savePath + fileName) ));
			jsonObject = (JSONObject) obj;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonObject;
	}
}
