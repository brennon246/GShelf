package com.derpicons.gshelf;

import android.view.View;
import android.widget.TextView;

class DealListViewCache {

	private View baseView;
	private TextView textDealLink;
	private TextView textDealEffect;

	// private ImageView imageCity;

	public DealListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextDealLink(int resource) {
		if (textDealLink == null) {
			textDealLink = (TextView) baseView
					.findViewById(R.id.DealTitleTextView);
		}
		return textDealLink;
	}

	public TextView getTextDealEffect(int resource) {
		if (textDealEffect == null) {
			textDealEffect = (TextView) baseView.findViewById(R.id.DealInfo);
		}
		return textDealEffect;
	}
	/*
	 * public ImageView getImageView (int resource) { if ( imageCity == null ) {
	 * imageCity = ( ImageView ) baseView.findViewById(R.id.ImageCity); } return
	 * imageCity; }
	 */
}
