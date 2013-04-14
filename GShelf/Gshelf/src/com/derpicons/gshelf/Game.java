package com.derpicons.gshelf;

import android.graphics.drawable.Drawable;

public class Game {

	private String title;
	private String platform;
	private String overview;
	private String genre;
	private String developer;
	private int key;
	private Drawable Cover;
	private String price;

	public Game() {
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

}
