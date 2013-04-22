package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TradeInfo extends Activity {
	
	final Button ButtonBuy = (Button) findViewById(R.id.buttonBuy);
	
	private String Username;
	private int Userkey;
	private int GameKey;
	private Game game;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trade_info);
		
		ctx = this;
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		final TextView TradeTitle = (TextView) findViewById(R.id.TradeTitleTextView);
		final ImageView TradeImage = (ImageView) findViewById(R.id.TradeCoverImageView);
		final TextView TradeConsole = (TextView) findViewById(R.id.TradeConsoleTextView);
		//final TextView TradeLocation = (TextView) findViewById(R.id.TradeLocationTextView);
		final TextView TradePrice = (TextView) findViewById(R.id.TradePriceTextView);
		GameKey = intent.getIntExtra("GameKey", 0);
		 
		game = new Network(ctx).getGame(GameKey);
		
		TradeTitle.setText(game.getTitle());
		TradeConsole.setText(game.getPlatform());
		TradePrice.setText(game.getPrice());
		TradeImage.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		if(TradeImage.getDrawable() == null)
			TradeImage.setImageDrawable(game.getCover());
		
		ButtonBuy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//sends message
			}
		});
		
	}
}