package com.derpicons.gshelf;


public class Trade {

	private Game tGame;
	private String Price;
	private Boolean isLocal;
	private Boolean isGlobal;
	private String Location;
	private Boolean isPaid;
	private Boolean isShipped;
	private Boolean isReceived;
	private int key;

	public Trade(Game g, String p, Boolean isL, Boolean isG, String Loc,
			Boolean isP, Boolean isS, Boolean isR, int k) {
		tGame = g;
		Price = p;
		isLocal = isL;
		isGlobal = isG;
		Location = Loc;
		isPaid = isP;
		isShipped = isS;
		isReceived = isR;
		key = k;
	}
	
	public Trade() {
	}

	public Game gettGame() {
		return tGame;
	}

	public void settGame(Game tGame) {
		this.tGame = tGame;
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

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Boolean getIsShipped() {
		return isShipped;
	}

	public void setIsShipped(Boolean isShipped) {
		this.isShipped = isShipped;
	}

	public Boolean getIsReceived() {
		return isReceived;
	}

	public void setIsReceived(Boolean isReceived) {
		this.isReceived = isReceived;
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

}
