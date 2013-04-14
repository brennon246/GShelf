package com.derpicons.gshelf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class GameListViewCache {

	private View baseView;
	private TextView textGameTitle;
	private TextView textGameConsole;
	private ImageView GameCover;

	// private ImageView imageCity;

	public GameListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextGameTitle(int resource) {
		if (textGameTitle == null) {
			textGameTitle = (TextView) baseView
					.findViewById(R.id.GameTitleTextView);
		}
		return textGameTitle;
	}

	public TextView getTextGameConsole(int resource) {
		if (textGameConsole == null) {
			textGameConsole = (TextView) baseView
					.findViewById(R.id.ConsoleTextView);
		}
		return textGameConsole;
	}

	public ImageView getGameCover(int resource) {
		if (GameCover == null) {
			GameCover = (ImageView) baseView.findViewById(R.id.CoverImageView);
		}
		return GameCover;
	}

}
