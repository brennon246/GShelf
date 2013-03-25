package com.derpicons.gshelf;

import java.sql.Date;
import java.util.ArrayList;

public class Deal {

	private Date ExpirationDate;
	private ArrayList<Tag> Tags;
	private String Link;
	private String Overview;
	private String Effect;
	private String Rating;
	private int Key;

	public Deal(Date e, ArrayList<Tag> t, String l, String o, String eff,
			String r, int k) {
		ExpirationDate = e;
		Tags = t;
		Link = l;
		Overview = o;
		Effect = eff;
		Rating = r;
		Key = k;
	}
	
	public Deal() {
	}

	public Date getExpirationDate() {
		return ExpirationDate;
	}

	public boolean isValid() {
		Date CurrentDate = new Date(System.currentTimeMillis());
		if (CurrentDate.before(ExpirationDate))
			return true;
		return false;

	}

	public String getLink() {
		return Link;
	}

	public int getKey() {
		return Key;
	}

	public ArrayList<Game> CheckGames(ArrayList<Game> GamesList) {
		ArrayList<Game> MatchedGames = new ArrayList<Game>();
		for (int k = 0; k < GamesList.size(); k++) {
			for (int i = 0; i < Tags.size(); i++) {
				if (Tags.get(i).isMatch(GamesList.get(k))) {
					MatchedGames.add(GamesList.get(k));
				}
			}
		}
		return MatchedGames;
	}

	public String getOverview() {
		return Overview;
	}

	public void setOverview(String overview) {
		Overview = overview;
	}

	public String getEffect() {
		return Effect;
	}

	public void setEffect(String effect) {
		Effect = effect;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}
}
