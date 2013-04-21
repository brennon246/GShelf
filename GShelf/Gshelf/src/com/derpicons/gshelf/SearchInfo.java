package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchInfo extends Activity {
	
	final Button ButtonAddWishlist = (Button) findViewById(R.id.buttonAddWishlist);
	final Button ButtonAddLibrary = (Button) findViewById(R.id.buttonAddLibrary);
	private String Username;
	private int Userkey;
	private int GameKey;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_info);
		
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		final TextView GameTitle = (TextView) findViewById(R.id.STitle);
		final TextView GameConsle = (TextView) findViewById(R.id.SConsole);
		final TextView GameDeveloper = (TextView) findViewById(R.id.SDeveloper);
		final TextView GameGenre = (TextView) findViewById(R.id.SGenre);
		final TextView GameOverview = (TextView) findViewById(R.id.SOverview);
		final TextView TradeImage = (TextView) findViewById(R.id.SImage);
		GameKey = intent.getIntExtra("GameKey", 0);
		
		ButtonAddWishlist.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey = intent.getIntExtra("GameKey", 0);
			}
		});
		
		ButtonAddLibrary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.game_info, menu);
		return true;
	}

}