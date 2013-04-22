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

public class SearchInfo extends Base_Activity {

	private String Username;
	private int Userkey;
	private int GameKey;
	private Context ctx;
	private Game game;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_info);
		
		ctx = this;
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		final Button ButtonAddWishlist = (Button) findViewById(R.id.buttonAddWishlist);
		final Button ButtonAddLibrary = (Button) findViewById(R.id.buttonAddLibrary);
		final TextView GameTitle = (TextView) findViewById(R.id.STitle);
		final TextView GameConsle = (TextView) findViewById(R.id.SConsole);
		final TextView GameDeveloper = (TextView) findViewById(R.id.SDeveloper);
		final TextView GameGenre = (TextView) findViewById(R.id.SGenre);
		final TextView GameOverview = (TextView) findViewById(R.id.SOverview);
		final TextView GamePrice = (TextView) findViewById(R.id.SPrice);
		final ImageView GameImage = (ImageView) findViewById(R.id.SImage);
		GameKey = intent.getIntExtra("GameKey", 0);
		//Network call to get Game with GameKey
		game = new Network(ctx).getGame(GameKey);
		
		GameTitle.setText(game.getTitle());
		GameConsle.setText(game.getPlatform());
		GameDeveloper.setText(game.getDeveloper());
		GameGenre.setText(game.getGenre());
		GameOverview.setText(game.getOverview());
		GamePrice.setText(game.getPrice());
		GameImage.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		if(GameImage.getDrawable() == null)
			GameImage.setImageDrawable(game.getCover());
		
		ButtonAddWishlist.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocalDatabase LD = new LocalDatabase(ctx);
				LD.addGameToWishlist(game, Float.parseFloat(game.getPrice()));
				LD.close();		
			}
		});
		
		ButtonAddLibrary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocalDatabase LD = new LocalDatabase(ctx);
				LD.addGameToLibrary(game);
				LD.close();

			}
		});
		
	}

}