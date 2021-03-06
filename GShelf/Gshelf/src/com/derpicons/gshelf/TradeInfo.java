package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TradeInfo extends Activity {

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
		
		final Button ButtonBuy = (Button) findViewById(R.id.buttonBuy);
		final TextView TradeTitle = (TextView) findViewById(R.id.TradeTitleTextView);
		final ImageView TradeImage = (ImageView) findViewById(R.id.TradeCoverImageView);
		final TextView TradeConsole = (TextView) findViewById(R.id.TradeConsoleTextView);
		final TextView TradeLocation = (TextView) findViewById(R.id.TradeLocationTextView);
		final TextView TradePrice = (TextView) findViewById(R.id.TradePriceTextView);
		TradeLocation.setText(" ");
		GameKey = intent.getIntExtra("GameKey", 0);

		game = new Network(ctx).getGame(GameKey);

		TradeTitle.setText(game.getTitle());
		TradeConsole.setText(game.getPlatform());
		TradePrice.setText("$ " + game.getPrice());
		TradeImage
				.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		if (TradeImage.getDrawable() == null)
			TradeImage.setImageDrawable(game.getCover());

		ButtonBuy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// sends message
			}
		});

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}
	
	private final String TAG = "Base_Activity";
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu
		getMenuInflater().inflate(R.menu.search, menu);
		//SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		//return super.onCreateOptionsMenu(menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.action_search:
			Log.i(TAG, "Action Search Clicked");
			
			Intent i = new Intent(getApplicationContext(), SearchActivity.class);
			i.putExtra("UserName", Username);
			i.putExtra("UKey", Userkey);
			startActivity(i);

			return true;
			
		case R.id.action_settings:
			Log.i(TAG, "Action Settings Clicked");
			return true;
			
		case R.id.action_logout:
			Log.i(TAG, "Action Logout Clicked");
			
			//delete shared preferences
			SharedPreferences settings = getSharedPreferences("GSHELF_LOGIN", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
				editor.remove("username");
				editor.remove("password");
				editor.commit();
			
			//intent return to login
			Intent j = new Intent(getApplicationContext(), Login.class);
			j.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(j);
			
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	//return true;	
	}
}