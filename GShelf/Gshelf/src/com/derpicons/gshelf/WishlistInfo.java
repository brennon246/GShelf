package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WishlistInfo extends Activity {
	
	final Button ButtonAddLibrary = (Button) findViewById(R.id.buttonAddLibrary);
	final Button ButtonBuy = (Button) findViewById(R.id.buttonBuy);
	final Button ButtonChangeThreshold = (Button) findViewById(R.id.buttonChangeThreshold);
	final Button ButtonRemove = (Button) findViewById(R.id.buttonRemove);
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
		
		final TextView GameTitle = (TextView) findViewById(R.id.WTitle);
		final TextView GameConsle = (TextView) findViewById(R.id.WConsole);
		final TextView GameDeveloper = (TextView) findViewById(R.id.WDevlop);
		final TextView GameGenre = (TextView) findViewById(R.id.WGenre);
		final TextView GamePrice = (TextView) findViewById(R.id.WPrice);
		final TextView GameOverview = (TextView) findViewById(R.id.WOverview);
		GameKey = intent.getIntExtra("GameKey", 0);
		 
		ButtonAddLibrary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey = intent.getIntExtra("GameKey", 0);
			}
		});
		
		ButtonBuy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey

			}
		});
		ButtonChangeThreshold.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//GameKey

			}
		});
		ButtonRemove.setOnClickListener(new View.OnClickListener() {

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
