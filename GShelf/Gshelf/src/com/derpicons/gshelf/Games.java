package com.derpicons.gshelf;

import java.util.ArrayList;

public class Games {

	private ArrayList<Game> AllGames;
	private ArrayList<Game> ShowGames;

	public Games(ArrayList<Game> AGames, ArrayList<Game> SGames) {
		AllGames = new ArrayList<Game>(AGames);
		SGames = new ArrayList<Game>(SGames);
	}

	public Games(ArrayList<Game> AGames) {
		AllGames = new ArrayList<Game>(AGames);
		ShowGames = new ArrayList<Game>(AGames);
	}

	public void Search(Tag T) {
		ShowGames.clear();
		// Searches Games
		for (int i = 0; i < AllGames.size(); i++) {
			if (T.isPartialMatch(AllGames.get(i))) {
				ShowGames.add(AllGames.get(i));
			}
		}

	}

	public void Refresh() {
		ShowGames.clear();
		// Searches Games
		for (Game item : AllGames)
			ShowGames.add(item);
	}

	public ArrayList<Game> getAllGames() {
		return AllGames;
	}

	public void setAllGames(ArrayList<Game> allGames) {
		AllGames = allGames;
	}

	public ArrayList<Game> getShowGames() {
		return ShowGames;
	}

	public void setShowGames(ArrayList<Game> showGames) {
		ShowGames = showGames;
	}

}
