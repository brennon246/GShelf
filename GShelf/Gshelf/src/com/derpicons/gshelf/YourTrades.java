package com.derpicons.gshelf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class YourTrades extends Activity {

	private ListView listViewOwned;
	private ListView listViewWTB;
	private Context ctx;
	private String Username;
	private int Userkey;
	private ArrayList<Trade> OwnedGames;
	private ArrayList<Game> WTBGames;
	private TradeListAdapter SelectedTradeListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_your_trades);
		ctx = this;

		// Get list of trades
		//OwnedGames = new ArrayList<Game>();
		//WTBGames = new ArrayList<Game>();
		//Get owned games
		//OwnedGames = new Network(ctx).getGames("halo");
		//get WTB games
		//WTBGames = new Network(ctx).getGames("halo");

		// Display list of games
		listViewOwned = (ListView) findViewById(R.id.o_trade_list);
		//listViewOwned.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
		//		OwnedGames));

		listViewOwned.setClickable(true);
		
		//listViewWTB = (ListView) findViewById(R.id.w_trade_list);
		//listViewWTB.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
		//		WTBGames));

		//listViewWTB.setClickable(true);

		listViewOwned.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				//Toast.makeText(getApplicationContext(),
				//		"Click GameItemNumber " + position, Toast.LENGTH_LONG)
				//		.show();
				// Takes user to GameView page with required data.
				
				Intent i = new Intent(getApplicationContext(), OwnedTradeInfo.class);
				i.putExtra("GameKey", WTBGames.get(position).getKey());
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
				
			}
		});
		/*
		listViewWTB.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				//Toast.makeText(getApplicationContext(),
				//		"Click GameItemNumber " + position, Toast.LENGTH_LONG)
				//		.show();
				// Takes user to GameView page with required data.
				
				Intent i = new Intent(getApplicationContext(), TradeInfo.class);
				i.putExtra("GameKey", WTBGames.get(position).getKey());
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
				
			}
		});
		*/
	}
	
	@Override
	protected void onResume() {
		super.onResume();

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		OwnedGames = new ArrayList<Trade>();
		OwnedGames = new Network(ctx).getMyMarket(Userkey);
		SelectedTradeListAdapter = new TradeListAdapter(ctx,
				R.layout.trade_item, OwnedGames);
		listViewOwned.setAdapter(SelectedTradeListAdapter);

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
