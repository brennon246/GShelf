package com.derpicons.gshelf;

import android.view.View;
import android.widget.TextView;

class TradeListViewCache {

	private View baseView;
	private TextView textGameTitle;
	private TextView textGamePrice;

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
			textGamePrice = (TextView) baseView.findViewById(R.id.TradeInfo);
		}
		return textGamePrice;
	}
	/*
	 * public ImageView getImageView (int resource) { if ( imageCity == null ) {
	 * imageCity = ( ImageView ) baseView.findViewById(R.id.ImageCity); } return
	 * imageCity; }
	 */
}
