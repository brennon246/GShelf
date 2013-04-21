package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TradeInfo extends Activity {
	
	final Button ButtonBuy = (Button) findViewById(R.id.buttonBuy);
	
	private String Username;
	private int Userkey;
	private int GameKey;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trade_info);
		
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		final TextView TradeTitle = (TextView) findViewById(R.id.TradeTitleTextView);
		final TextView TradeImage = (TextView) findViewById(R.id.TradeCoverImageView);
		final TextView TradeConsole = (TextView) findViewById(R.id.TradeConsoleTextView);
		final TextView TradeLocation = (TextView) findViewById(R.id.TradeLocationTextView);
		final TextView TradePrice = (TextView) findViewById(R.id.TradePriceTextView);
		GameKey = intent.getIntExtra("GameKey", 0);
		 
		ButtonBuy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey = intent.getIntExtra("GameKey", 0);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.trade_info, menu);
		return true;
	}

}