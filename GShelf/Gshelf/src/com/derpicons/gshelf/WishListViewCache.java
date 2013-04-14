package com.derpicons.gshelf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class WishListViewCache {

	private View baseView;
	private TextView textGameTitle;
	private TextView textGamePrice;
	private TextView textGameConsole;
	private ImageView WGameCover;

	// private ImageView imageCity;

	public WishListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextGameTitle(int resource) {
		if (textGameTitle == null) {
			textGameTitle = (TextView) baseView
					.findViewById(R.id.WGameTitleTextView);
		}
		return textGameTitle;
	}

	public TextView getTextGamePrice(int resource) {
		if (textGamePrice == null) {
			textGamePrice = (TextView) baseView.findViewById(R.id.WPriceTextView);
		}
		return textGamePrice;
	}
	
	public TextView getTextGameConsole(int resource) {
		if (textGameConsole == null) {
			textGameConsole = (TextView) baseView.findViewById(R.id.WConsoleTextView);
		}
		return textGameConsole;
	}
	
	public ImageView getWGameCover(int resource) {
		if (WGameCover == null) {
			WGameCover = (ImageView) baseView.findViewById(R.id.WCoverImageView);
		}
		return WGameCover;
	}
}
