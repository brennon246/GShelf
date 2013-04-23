package com.derpicons.gshelf;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class Marketplace extends Activity {

	private ListView listViewTrades;
	private TradeListAdapter SelectedTradeListAdapter;
	private Context ctx;
	private String Username;
	private int Userkey;
	ArrayList<Trade> TradeGames;
	
	// swipe constants
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;

	private GestureDetector gestureDetector;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marketplace);
		
		// Listen for swipes
		gestureDetector = new GestureDetector(this,
				new OnSwipeGestureListener());
		
		//Button SearchButton = (Button) findViewById(R.id.buttonSearch);
		Button YourTradesButton = (Button) findViewById(R.id.buttonYourTrades);
		//final EditText SearchText = (EditText) findViewById(R.id.editTextSearch);
		ctx = this;

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		listViewTrades = (ListView) findViewById(R.id.trade_list);
		listViewTrades.setClickable(true);
		
		YourTradesButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						YourTrades.class);
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
				
			}
		});
		/*
		SearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String search = SearchText.getText().toString();
				TradeGames = new ArrayList<Game>();
				if (search.length() != 0) {
					//TradeGames = new Network(ctx).getTrades(search);
				}
				TradeGames = new Network(ctx).getGames("halo");
				listViewTrades.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
						TradeGames));
				
			}
		});
		*/
		listViewTrades.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				Intent i = new Intent(getApplicationContext(), TradeInfo.class);
				i.putExtra("GameKey", TradeGames.get(position).getGameKey());
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();

		TradeGames = new ArrayList<Trade>();
		TradeGames = new Network(ctx).getMarket();
		SelectedTradeListAdapter = new TradeListAdapter(ctx,
				R.layout.trade_item, TradeGames);
		listViewTrades.setAdapter(SelectedTradeListAdapter);

	}

	// Swipe accessor function
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	// Swipe Class
	private class OnSwipeGestureListener extends
			GestureDetector.SimpleOnGestureListener {
		// Swipe movement evaluation
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {

			float deltaX = e2.getX() - e1.getX();

			if ((Math.abs(deltaX) < SWIPE_MIN_DISTANCE)
					|| (Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY)) {
				return false; // insignificant swipe
			} else {
				if (deltaX < 0) { // left to right
					handleSwipeLeftToRight();
				} else { // right to left
					handleSwipeRightToLeft();
				}
			}
			return true;
		}
	}

	// Handle swipe from left to right
	private void handleSwipeLeftToRight() {
		Intent i = new Intent(getApplicationContext(), Wishlist.class);
		i.putExtra("UserName", Username);
		i.putExtra("UKey", Userkey);
		startActivity(i);
	}

	// Handle swipe from right to left
	private void handleSwipeRightToLeft() {
		Intent i = new Intent(getApplicationContext(), DealsView.class);
		i.putExtra("UserName", Username);
		i.putExtra("UKey", Userkey);
		startActivity(i);
	}

	private final String TAG = "Base_Activity";
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu
		getMenuInflater().inflate(R.menu.main_menu, menu);
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
