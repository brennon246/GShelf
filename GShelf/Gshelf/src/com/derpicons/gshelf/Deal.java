package com.derpicons.gshelf;

import java.sql.Date;
import java.util.ArrayList;

import android.graphics.drawable.Drawable;

public class Deal {

	private Date ExpirationDate;
	private ArrayList<Tag> Tags;
	private String Source;
	private String Description;
	private int Key;

	public Deal(Date e, ArrayList<Tag> t, String s, String dis, int k) {
		ExpirationDate = e;
		setSource(s);
		Tags = t;
		Description = dis;
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

	public String setDescription() {
		return Description;
	}
	
	public String getDescription() {
		return Description;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}
}
