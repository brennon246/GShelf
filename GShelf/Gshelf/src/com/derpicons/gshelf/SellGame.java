package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class SellGame extends Base_Activity {

	private String Username;
	private int Userkey;
	private int GameKey;
	private Context ctx;
	private Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell_game);

		final Button ButtonSell = (Button) findViewById(R.id.buttonSell);

		ctx = this;
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		GameKey = intent.getIntExtra("GameKey", 0);
		final EditText price = (EditText) findViewById(R.id.editTextPrice);
		final EditText zipCode = (EditText) findViewById(R.id.editTextZipCode);
		final TextView priceTextView = (TextView) findViewById(R.id.textViewPrice);
		final TextView zipCodeTextView = (TextView) findViewById(R.id.textViewZipCode);
		final TextView GameTitle = (TextView) findViewById(R.id.textViewGameTitle);
		final TextView GameConsole = (TextView) findViewById(R.id.textViewGameConsole);
		final RadioButton local = (RadioButton) findViewById(R.id.radioLocal);
		final ImageView GameImage = (ImageView) findViewById(R.id.imageViewGameCover);
		
		game = new Network(ctx).getGame(GameKey);

		GameTitle.setText(game.getTitle());
		GameConsole.setText(game.getPlatform());
		GameImage.setImageDrawable(new Network(ctx).getImage(game.getGameUrl()));
		
		ButtonSell.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				boolean complete = true;
				if (price.getText().toString().length() == 0) {
					priceTextView.setTextColor(Color.RED);
					complete = false;
				} else
					priceTextView.setTextColor(Color.WHITE);
				if (local.isChecked()) {
					if (zipCode.getText().toString().length() == 0) {
						zipCodeTextView.setTextColor(Color.RED);
						complete = false;
					} else
						zipCodeTextView.setTextColor(Color.WHITE);
				}
				new Network(ctx).addToMarket(Userkey, GameKey, price.getText()
						.toString());
				finish();
			}
		});
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
