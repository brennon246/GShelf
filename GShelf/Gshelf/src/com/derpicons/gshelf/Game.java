package com.derpicons.gshelf;

import java.util.Random;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Game {

	private String gameUrl;
	private String title;
	private String platform;
	private String overview;
	private String genre;
	private String priceThreshold;
	private String developer;
	private int key;
	private Drawable Cover;
	private String price;
	private Context ctxt;

	public Game(Context context) {
		//gameUrl = " ";
		title = " ";
		platform = " ";
		overview = " ";
		genre = " ";
		developer = " ";
		key = -1;
		Random random = new Random();
		int Low = 15;
		int High = 45;
		int randomNum = random.nextInt(High-Low) + Low;
		price = "$ " + Integer.toString(randomNum) + ".99";
		ctxt = context;
		Cover = ctxt.getResources().getDrawable(R.drawable.no_image);
		
		
	}
	
	public Game(String t, String o) {
		title = t;
		overview = o;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Drawable getCover() {
		return Cover;
	}

	public void setCover(Drawable cover) {
		Cover = cover;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGameUrl() {
		return gameUrl;
	}

	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}

	public String getPriceThreshold() {
		return priceThreshold;
	}

	public void setPriceThreshold(String priceThreshold) {
		this.priceThreshold = priceThreshold;
	}

}
