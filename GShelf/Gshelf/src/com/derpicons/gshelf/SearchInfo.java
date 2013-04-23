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
import android.widget.Toast;

public class SearchInfo extends Activity {

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
		// Network call to get Game with GameKey
		game = new Network(ctx).getGame(GameKey);

		GameTitle.setText(game.getTitle());
		GameConsle.setText(game.getPlatform());
		GameDeveloper.setText(game.getDeveloper());
		GameGenre.setText(game.getGenre());
		GameOverview.setText(game.getOverview());
		GamePrice.setText("$ " + game.getPrice());
		GameImage
				.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		if (GameImage.getDrawable() == null)
			GameImage.setImageDrawable(game.getCover());

		ButtonAddWishlist.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocalDatabase LD = new LocalDatabase(ctx);
				LD.addGameToWishlist(game, Float.parseFloat(game.getPrice()));
				LD.close();
				Toast.makeText(getApplicationContext(), "Added to Wishlist",
						Toast.LENGTH_LONG).show();
			}
		});

		ButtonAddLibrary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocalDatabase LD = new LocalDatabase(ctx);
				LD.addGameToLibrary(game);
				LD.close();
				Toast.makeText(getApplicationContext(), "Added to Library",
						Toast.LENGTH_LONG).show();

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