package com.derpicons.gshelf;


public class Trade {

	private int GameKey;
	private String Price;
	private Boolean isLocal;
	private Boolean isGlobal;
	private String Location;
	private int Sellerid;
	private int key;
	
	public Trade() {
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public Boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(Boolean isLocal) {
		this.isLocal = isLocal;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public int getGameKey() {
		return GameKey;
	}
	
	public int setGameKey() {
		return GameKey;
	}

	public int getSellerid() {
		return Sellerid;
	}

	public void setSellerid(int sellerid) {
		Sellerid = sellerid;
	}

}
