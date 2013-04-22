package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameInfo extends Activity {
	
	private String Username;
	private int Userkey;
	private int GameKey;
	private Game game;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_info);
		
		ctx = this;
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
		final ImageView GameImage = (ImageView) findViewById(R.id.imageViewGameCover);
		GameKey = intent.getIntExtra("GameKey", 0);
		 
		game = new Network(ctx).getGame(GameKey);
		
		GameTitle.setText(game.getTitle());
		GameConsle.setText(game.getPlatform());
		GameDeveloper.setText(game.getDeveloper());
		GameGenre.setText(game.getGenre());
		GameOverview.setText(game.getOverview());
		GameImage.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		//GameImage.setImageDrawable(game.getCover());
		
		if(GameImage.getDrawable() == null)
			GameImage.setImageDrawable(game.getCover());
		
		ButtonSell.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent i = new Intent(getApplicationContext(),
						SellGame.class);
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				i.putExtra("GameKey", GameKey);
				startActivity(i);
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
}
