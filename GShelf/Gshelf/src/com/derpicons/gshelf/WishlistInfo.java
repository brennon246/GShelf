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

public class WishlistInfo extends Base_Activity {

	private String Username;
	private int Userkey;
	private int GameKey;
	private Context ctx;
	private Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wishlist_info);

		ctx = this;
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);

		final Button ButtonAddLibrary = (Button) findViewById(R.id.buttonAddLibrary);
		final Button ButtonBuy = (Button) findViewById(R.id.buttonBuy);
		ButtonBuy.setVisibility(View.GONE);
		final Button ButtonThreshold = (Button) findViewById(R.id.buttonThreshold);
		final Button ButtonRemove = (Button) findViewById(R.id.buttonRemove);

		final TextView GameTitle = (TextView) findViewById(R.id.WTitle);
		final TextView GameConsle = (TextView) findViewById(R.id.WConsole);
		final TextView GameDeveloper = (TextView) findViewById(R.id.WDevlop);
		final TextView GameGenre = (TextView) findViewById(R.id.WGenre);
		final TextView GamePrice = (TextView) findViewById(R.id.WPrice);
		final TextView GameOverview = (TextView) findViewById(R.id.WOverview);
		final ImageView GameImage = (ImageView) findViewById(R.id.WPic);
		GameKey = intent.getIntExtra("GameKey", 0);

		game = new Network(ctx).getGame(GameKey);

		GameTitle.setText(game.getTitle());
		GameConsle.setText(game.getPlatform());
		GameDeveloper.setText(game.getDeveloper());
		GameGenre.setText(game.getGenre());
		GameOverview.setText(game.getOverview());
		GamePrice.setText(game.getPrice());
		// GameImage.setImageDrawable(game.getCover());
		GameImage
				.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));

		if (GameImage.getDrawable() == null)
			GameImage.setImageDrawable(game.getCover());

		ButtonAddLibrary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocalDatabase LD = new LocalDatabase(ctx);
				LD.addGameToLibrary(game);
				// need to remove from wishlist
				LD.close();
			}
		});

		ButtonBuy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// GameKey

			}
		});
		ButtonThreshold.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// GameKey

			}
		});
		ButtonRemove.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// GameKey

			}
		});

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}

}
