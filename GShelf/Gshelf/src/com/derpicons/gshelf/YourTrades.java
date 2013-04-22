package com.derpicons.gshelf;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class YourTrades extends Base_Activity {

	private ListView listViewOwned;
	private ListView listViewWTB;
	private Context ctx;
	private String Username;
	private int Userkey;
	private ArrayList<Game> OwnedGames;
	private ArrayList<Game> WTBGames;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_your_trades);
		ctx = this;

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);

		// Get list of trades
		OwnedGames = new ArrayList<Game>();
		WTBGames = new ArrayList<Game>();
		//Get owned games
		OwnedGames = new Network(ctx).getGames("halo");
		//get WTB games
		WTBGames = new Network(ctx).getGames("halo");

		// Display list of games
		listViewOwned = (ListView) findViewById(R.id.o_trade_list);
		listViewOwned.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
				OwnedGames));

		listViewOwned.setClickable(true);
		
		listViewWTB = (ListView) findViewById(R.id.w_trade_list);
		listViewWTB.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
				WTBGames));

		listViewWTB.setClickable(true);

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
	}

}
