package com.derpicons.gshelf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;


public class Network {
	
	private static final Map<Integer,String> errorMap = new HashMap<Integer,String>();
	
	ArrayList<Game> getGames(String name)
	{
		//should use string.format
		String url = "http://thegamesdb.net/api/GetGame.php?name=" + name;
		
		//create the http get from the url
		HttpGet getMethod = new HttpGet(url);
		
		
		
		DefaultHttpClient client = new DefaultHttpClient();
		String responseBody = "nil";
		
		try {
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			 responseBody = client.execute(getMethod, responseHandler);
			
			
			return parseResponse(responseBody);
		} 
		catch (Throwable t){
			//can use t as a string to pass to logcat to display error
			Log.i("ERROR", t.toString());
			
			return null;
		}
		
		
		
	}
	
	//parses response from getGames API call
	ArrayList<Game> parseResponse(String rawResponse) throws Exception
	{
		//converting String containg raw XML to inputstream
		InputStream iStream = new ByteArrayInputStream(rawResponse.getBytes());
		
		//set up XML pull parser
		XmlPullParser parser = Xml.newPullParser();
		
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(iStream, null);
        parser.nextTag();
        
        parser.require(XmlPullParser.START_TAG, null, "Data");
        
        ArrayList<Game> games = new ArrayList<Game>();
        
        while (parser.next() != XmlPullParser.END_TAG){
        	if(parser.getEventType() != XmlPullParser.START_TAG){
        		continue;
        	}
        	
        	String name = parser.getName();
        	
        	
        	if(name.equals("Game")){
        		games.add(parseGame(parser));
        	}
        	else{
        		skip(parser);
        	}
        }
        

		iStream.close();
		return games;
	}
	
	Game parseGame(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		
		Game newGame = new Game();
		while(parser.next() != XmlPullParser.END_TAG){
			if(parser.getEventType() != XmlPullParser.START_TAG){
				continue;
			}
			
			String tagName = parser.getName();
			
			if(tagName.equals("GameTitle")){
				newGame.title = parseGameTitle(parser,newGame);
			
			}
			
			else if(tagName.equals("Platform")){
				newGame.platform = parsePlatform(parser, newGame);
			}
			
			else if(tagName.equals("Overview")){
				newGame.overview = parseOverview(parser, newGame);
			}
			
			else{
				skip(parser);
			}
			
		
			
		}
		
		return newGame;
	}
	
	String parseGameTitle(XmlPullParser parser, Game game) throws IOException, XmlPullParserException{
		parser.require(XmlPullParser.START_TAG, null, "GameTitle");
		String gameTitle = "null";
		
		if(parser.next() == XmlPullParser.TEXT){
			gameTitle = parser.getText();
			parser.nextTag();
		}
		
		return gameTitle;
	}
	
	String parsePlatform(XmlPullParser parser, Game game) throws IOException, XmlPullParserException{
		parser.require(XmlPullParser.START_TAG, null, "Platform");
		String platform = "null";
		
		if(parser.next() == XmlPullParser.TEXT){
			platform = parser.getText();
			parser.nextTag();
		}
		

		
		return platform;
	}
	
	String parseOverview(XmlPullParser parser, Game game) throws IOException, XmlPullParserException{
		parser.require(XmlPullParser.START_TAG, null, "Overview");
		String overview = "null";
		
		if(parser.next() == XmlPullParser.TEXT){
			overview = parser.getText();
			parser.nextTag();
		}
		
		return overview;
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
	
	
	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
	    if (parser.getEventType() != XmlPullParser.START_TAG) {
	        throw new IllegalStateException();
	    }
	    int depth = 1;
	    while (depth != 0) {
	        switch (parser.next()) {
	        case XmlPullParser.END_TAG:
	            depth--;
	            break;
	        case XmlPullParser.START_TAG:
	            depth++;
	            break;
	        }
	    }
	 }
	

}
