package com.derpicons.gshelf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class DealListViewCache {

	private View baseView;
	private TextView textDealEffect;
	private ImageView DealImage;

	// private ImageView imageCity;

	public DealListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextDealEffect(int resource) {
		if (textDealEffect == null) {
			textDealEffect = (TextView) baseView.findViewById(R.id.DealEffectTextView);
		}
		return textDealEffect;
	}
	
	public ImageView getDealImage(int resource) {
		if (DealImage == null) {
			DealImage = (ImageView) baseView.findViewById(R.id.DealImageView);
		}
		return DealImage;
	}
	
	
	/*
	 * public ImageView getDealImageView (int resource) { if ( imageCity == null ) {
	 * imageCity = ( ImageView ) baseView.findViewById(R.id.DealImageView); } return
	 * imageCity; }
	 */
}
