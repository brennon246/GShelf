package com.derpicons.gshelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;


public class Network {
	
	private static final Map<Integer,String> errorMap = new HashMap<Integer,String>();
	
	ArrayList<Game> getGames(String name)
	{
		//should use string.format
		String url = "http://thegamesdb.net/api/GetGame.php?name=" + name;
		
		//create the http get from the url
		HttpGet getMethod = new HttpGet(url);
		
		
		
		DefaultHttpClient client = new DefaultHttpClient();
		
		try {
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = client.execute(getMethod, responseHandler);
			Log.i("RESPONSE BODY", responseBody);
			
			return parseResponse(responseBody);
		} 
		catch (Throwable t){
			//can use t as a string to pass to logcat to display error
			Log.i("ERROR", t.toString());
			
			return null;
		}
		
		
		
	}
	
	ArrayList<Game> parseResponse(String response)
	{
		return null;
	}
	
	String authenticate(String username, String password)
	{
		//implement authentication logic
		
		String authResult = "null";
		
		return authResult;
		
		
	}
	
	boolean hasNetwork()
	{
		boolean isNetwork;
		
		isNetwork = true;
		
		return isNetwork; 
	}
	
	

}
