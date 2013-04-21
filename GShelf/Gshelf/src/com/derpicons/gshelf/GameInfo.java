package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameInfo extends Activity {
	
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
		final Button ButtonSell = (Button) findViewById(R.id.buttonSell);
		final Button ButtonRemove = (Button) findViewById(R.id.buttonRemove);
		final TextView GameTitle = (TextView) findViewById(R.id.textViewGameTitle);
		final TextView GameConsle = (TextView) findViewById(R.id.imageViewGameConsole);
		final TextView GameDeveloper = (TextView) findViewById(R.id.textViewDeveloper);
		final TextView GameGenre = (TextView) findViewById(R.id.textViewGameGenre);
		final TextView GameOverview = (TextView) findViewById(R.id.textViewGameOverview);
		GameKey = intent.getIntExtra("GameKey", 0);
		 
		ButtonSell.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			}
		});
		
		ButtonRemove.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//LocalDatabase LD = new LocalDatabase(ctx);
				//LD.RemoveFromLibrary(game, game.getPrice());
				//LD.close();

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
