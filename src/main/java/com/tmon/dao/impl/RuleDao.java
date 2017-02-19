package com.tmon.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tmon.dao.IGetJsonDao;

public class RuleDao implements IGetJsonDao{
	private String savePath;
	
	public RuleDao(String savePath)
	{
		this.savePath = savePath;
	}
	
	@Override
	public JSONObject getJson()
	{
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		String fileName = "settingDB_table.json";
		
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
