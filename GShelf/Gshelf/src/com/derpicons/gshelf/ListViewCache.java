package com.derpicons.gshelf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewCache {

	private View baseView;
	private TextView textDealEffect;
	private TextView textGameTitle;
	private TextView textGameConsole;
	private ImageView GameCover;
	private TextView textTGameTitle;
	private TextView textTGamePrice;
	private TextView textTradeLocation;
	private TextView textTGameConsole;
	private ImageView TGameCover;
	private TextView textWGameTitle;
	private TextView textWGamePrice;
	private TextView textWGameConsole;
	private ImageView WGameCover;
	private TextView textNotificationActivity;
	private TextView textNotificationMessage;
	private TextView textSearchGameTitle;
	private TextView textSearchGameConsole;


	public ListViewCache(View baseView) {

		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	//Deals
	public TextView getTextDealEffect(int resource) {
		if (textDealEffect == null) {
			textDealEffect = (TextView) baseView
					.findViewById(R.id.DealEffectTextView);
		}
		return textDealEffect;
	}
	
	//Game Library
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
	
	//Marketplace
	public TextView getTextTGameTitle(int resource) {
		if (textTGameTitle == null) {
			textTGameTitle = (TextView) baseView
					.findViewById(R.id.TradeTitleTextView);
		}
		return textTGameTitle;
	}
	
	public TextView getTextTGamePrice(int resource) {
		if (textTGamePrice == null) {
			textTGamePrice = (TextView) baseView.findViewById(R.id.TradePriceTextView);
		}
		return textTGamePrice;
	}
	
	public TextView getTextTradeLocation(int resource) {
		if (textTradeLocation == null) {
			textTradeLocation = (TextView) baseView.findViewById(R.id.TradeLocationTextView);
		}
		return textTradeLocation;
	}
	
	public TextView getTextTGameConsole(int resource) {
		if (textTGameConsole == null) {
			textTGameConsole = (TextView) baseView.findViewById(R.id.TradeConsoleTextView);
		}
		return textTGameConsole;
	}
	
	public ImageView getTGameCover(int resource) {
		if (TGameCover == null) {
			TGameCover = (ImageView) baseView.findViewById(R.id.TradeCoverImageView);
		}
		return TGameCover;
	}
	
	//Wishlist
	public TextView getTextWGameTitle(int resource) {
		if (textWGameTitle == null) {
			textWGameTitle = (TextView) baseView
					.findViewById(R.id.WGameTitleTextView);
		}
		return textWGameTitle;
	}

	public TextView getTextWGamePrice(int resource) {
		if (textWGamePrice == null) {
			textWGamePrice = (TextView) baseView.findViewById(R.id.WPriceTextView);
		}
		return textWGamePrice;
	}
	
	public TextView getTextWGameConsole(int resource) {
		if (textWGameConsole == null) {
			textWGameConsole = (TextView) baseView.findViewById(R.id.WConsoleTextView);
		}
		return textWGameConsole;
	}
	
	public ImageView getWGameCover(int resource) {
		if (WGameCover == null) {
			WGameCover = (ImageView) baseView.findViewById(R.id.WCoverImageView);
		}
		return WGameCover;
	}
	
	public TextView getTextNotificationActivity(int resource) {
		if (textNotificationActivity == null) {
			textNotificationActivity = (TextView) baseView.findViewById(R.id.NotificationActivity);
		}
		return textNotificationActivity;
	}
	
	public TextView getTextNotificationMessage(int resource) {
		if (textNotificationMessage == null) {
			textNotificationMessage = (TextView) baseView.findViewById(R.id.NotificationMessage);
		}
		return textNotificationMessage;
	}
	
	public TextView getTextSearchGameTitle(int resource) {
		if (textSearchGameTitle == null) {
			textSearchGameTitle = (TextView) baseView.findViewById(R.id.RGameTitleTextView);
		}
		return textSearchGameTitle;
	}
	
	public TextView getTextSearchGameConsole(int resource) {
		if (textSearchGameConsole == null) {
			textSearchGameConsole = (TextView) baseView.findViewById(R.id.RConsoleTextView);
		}
		return textSearchGameConsole;
	}
}
