package com.derpicons.gshelf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class TradeListViewCache {

	private View baseView;
	private TextView textGameTitle;
	private TextView textGamePrice;
	private TextView textTradeLocation;
	private TextView textGameConsole;
	private ImageView TGameCover;	

	// private ImageView imageCity;

	public TradeListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextGameTitle(int resource) {
		if (textGameTitle == null) {
			textGameTitle = (TextView) baseView
					.findViewById(R.id.TradeTitleTextView);
		}
		return textGameTitle;
	}
	
	public TextView getTextGamePrice(int resource) {
		if (textGamePrice == null) {
			textGamePrice = (TextView) baseView.findViewById(R.id.TradePriceTextView);
		}
		return textGamePrice;
	}
	
	public TextView getTextTradeLocation(int resource) {
		if (textTradeLocation == null) {
			textTradeLocation = (TextView) baseView.findViewById(R.id.TradeLocationTextView);
		}
		return textTradeLocation;
	}
	
	public TextView getTextGameConsole(int resource) {
		if (textGameConsole == null) {
			textGameConsole = (TextView) baseView.findViewById(R.id.TradeConsoleTextView);
		}
		return textGameConsole;
	}
	
	public ImageView getTGameCover(int resource) {
		if (TGameCover == null) {
			TGameCover = (ImageView) baseView.findViewById(R.id.TradeCoverImageView);
		}
		return TGameCover;
	}
}
