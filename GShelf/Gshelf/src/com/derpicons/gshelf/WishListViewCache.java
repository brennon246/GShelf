package com.derpicons.gshelf;

import android.view.View;
import android.widget.TextView;

class WishListViewCache {

	private View baseView;
	private TextView textGameTitle;
	private TextView textGameInfo;

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

	public TextView getTextGameInfo(int resource) {
		if (textGameInfo == null) {
			textGameInfo = (TextView) baseView.findViewById(R.id.WGameInfo);
		}
		return textGameInfo;
	}
	/*
	 * public ImageView getImageView (int resource) { if ( imageCity == null ) {
	 * imageCity = ( ImageView ) baseView.findViewById(R.id.ImageCity); } return
	 * imageCity; }
	 */
}
